package com.fran.controller;

import com.fran.mapper.ArticleMapper;
import com.fran.mapper.CommentMapper;
import com.fran.mapper.StudentMapper;
import com.fran.pojo.Articles;
import com.fran.pojo.Comments;
import com.fran.pojo.Student;
import com.fran.pojo.Search;
import com.fran.service.ArticleService;
import com.fran.service.CommentService;
import com.fran.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class PublishController {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CommentMapper commentMapper;


    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private StudentService studentService;


    @GetMapping("/publish")
    public String publish(Model model) throws ParseException {

        List<Articles> articles = articleMapper.getAll();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();



        for(int i=0;i<articles.size();i++){
            Student student = studentMapper.get(articles.get(i).getAuthor());
            articles.get(i).setName(student.getName());
            articles.get(i).setDate2(sdf.format(articles.get(i).getDate()));
            articles.get(i).setComNum(articleMapper.getComNum(articles.get(i).getId()));


        }



        model.addAttribute("articles",articles);




        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");









        List<Comments> comments =  commentMapper.getAll();
        if(comments.size() > 4){
          comments = comments.subList(0,4);
        }
        for(int i=0;i<comments.size();i++){
            comments.get(i).setName(studentMapper.get(comments.get(i).getWho()).getName());
            comments.get(i).setToName(studentMapper.get(comments.get(i).getToto()).getName());
            comments.get(i).setDate2(sdf1.format(comments.get(i).getDate()));
            comments.get(i).setTitle(articleService.get(comments.get(i).getArticleId()).getTitle());
        }



        model.addAttribute("comments",comments);

        System.out.println(comments);
        return "publish/articles-list";
    }



    @RequestMapping("/single/{id}")
    public String single(@PathVariable("id")Integer id,Model model){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");




        Articles article = articleMapper.get(id);
        Student student = studentMapper.get(article.getAuthor());
        article.setName(student.getName());
        article.setComNum(articleMapper.getComNum(id));
        article.setDate2(sdf.format(article.getDate()));

        model.addAttribute("article",article);


        List<Comments> comments =  commentMapper.getAll();
        for(int i=0;i<comments.size();i++){
            comments.get(i).setName(studentMapper.get(comments.get(i).getWho()).getName());
            comments.get(i).setToName(studentMapper.get(comments.get(i).getToto()).getName());
            comments.get(i).setDate2(sdf1.format(comments.get(i).getDate()));
        }

        model.addAttribute("comments",comments);

        System.out.println(comments);
        return "publish/single";
    }

    @GetMapping("/article/add")
    public String articleAdd(){
        return "publish/publish";
    }





    @PostMapping("/article/comment")
    @ResponseBody
    public String add(Comments comments, Model model, HttpSession session){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        comments.setWho(Integer.parseInt((String) session.getAttribute("loginStu")) );
        Date date = new Date();
        comments.setDate(date);
        comments.setDate2(sdf.format(comments.getDate()));

        if(comments.getComId() == -1) {
            if (articleMapper.getComNum(comments.getArticleId()) == 0) {
                comments.setComId(1);
            }else {


                comments.setComId(articleMapper.lastComId(comments.getArticleId()) + 1);
            }
        }

        commentService.save(comments);

        System.out.println(comments);
        return "1";
    }


    @PostMapping("/article/publish")
    @ResponseBody
    public String publishArticle(Articles article,HttpSession session){
        article.setAuthor(Integer.parseInt((String) session.getAttribute("loginStu")));
        Date date = new Date();
        article.setDate(date);
        articleService.save(article);
        System.out.println(article);
        return "1";
    }

    @PostMapping("/article/search")
//    @RequestMapping(value = "/article/search",method = RequestMethod.GET)
//    @ResponseBody
    public String search(Search search, Model model, HttpSession session){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(search);
        List<Articles> articles;

        if(search.getType().equals("title")) {
            System.out.println(search.getContent());
            articles = articleMapper.getByTitle(search.getContent());
        }
        else if (search.getType().equals("author"))
            articles = articleMapper.getByName(search.getContent());
        else
            articles = articleMapper.getByTag(search.getContent());


        Calendar calendar = Calendar.getInstance();


        System.out.println(articles);

        for(int i=0;i<articles.size();i++){
            Student student = studentMapper.get(articles.get(i).getAuthor());
            articles.get(i).setName(student.getName());
            articles.get(i).setDate2(sdf.format(articles.get(i).getDate()));
            articles.get(i).setComNum(articleMapper.getComNum(articles.get(i).getId()));

        }



        model.addAttribute("articles",articles);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


//        List<Comments> comments =  commentMapper.getAll();
//        if(comments.size() > 4){
//            comments = comments.subList(0,4);
//        }
//        for(int i=0;i<comments.size();i++){
//            comments.get(i).setName(studentMapper.get(comments.get(i).getWho()).getName());
//            comments.get(i).setToName(studentMapper.get(comments.get(i).getToto()).getName());
//            comments.get(i).setDate2(sdf1.format(comments.get(i).getDate()));
//            comments.get(i).setTitle(articleService.get(comments.get(i).getArticleId()).getTitle());
//        }
//
//
//
//        model.addAttribute("comments",comments);

//        System.out.println(comments);
        return "publish/articles-list::articles";
    }
}
