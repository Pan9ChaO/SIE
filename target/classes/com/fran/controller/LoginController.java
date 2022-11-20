package com.fran.controller;

import com.fran.mapper.QuestionDao;
import com.fran.pojo.Question;
import com.fran.pojo.Student;
import com.fran.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class LoginController {
    @Autowired
    QuestionDao questionDao;

    @Autowired
    StudentService studentService;


    @GetMapping("/front")
    public String front(){
        return "dashboard";
    }


    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        //具体的业务
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html" ;
        }else{
            model.addAttribute("msg","用户名或者密码错误");
            return "index" ;
        }

    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login_stu.html" ;
    }

    @RequestMapping("/stu/login")
    public String stuLogin(@RequestParam("id")String id,@RequestParam("pwd")String password,Model model,HttpSession session){


        Student student = studentService.get(Integer.parseInt(id));
        if(student == null){
            model.addAttribute("msg","Student not exist !");
            return "login_stu";
        }
        String pwd = student.getPwd();
        System.out.println(student);
        System.out.println(pwd.equals(password));
        if( pwd.equals(password)){
            session.setAttribute("loginStu",id);
            return "redirect:/main.html" ;
        }else{
            model.addAttribute("msg","password is wrong !");
            System.out.println("");
            return "login_stu";
        }
    }



    @GetMapping("/stu/regist")
    public String registUser(Model model){
        Collection<Question> questions = questionDao.getQuestions();
        model.addAttribute("questions",questions);
        return "register";
    }


    @GetMapping("/stu/findPwd")
    public String findPwd(Model model){
        Collection<Question> questions = questionDao.getQuestions();
        model.addAttribute("questions",questions);
        return "find/check";
    }





}
