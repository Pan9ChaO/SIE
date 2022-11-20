package com.fran.controller;


import com.fran.pojo.Articles;
import com.fran.pojo.Course;
import com.fran.pojo.Search;
import com.fran.pojo.Student;
import com.fran.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class TutorController {

    @Autowired
    private TutorService tutorService;


    @GetMapping("/tutor/service")
    public String tutor(Model model){
        Date date = new Date();
        List<Course> courses = tutorService.getCourse();

        List<Time> allTimes = null;
        for(int i=0;i<courses.size();i++){
           allTimes = tutorService.getTimes(courses.get(i).getTeacher(),courses.get(i).getName());
            courses.get(i).setTimes(allTimes);
            courses.get(i).setLight(false);

            for(int j=0; j<courses.get(i).getTimes().size();j++){

                if(Integer.parseInt(courses.get(i).getTimes().get(j).toString().substring(0,2)) - date.getHours() <=1 && Integer.parseInt(courses.get(i).getTimes().get(j).toString().substring(0,2)) - date.getHours() >=0){
                    courses.get(i).setLight(true);
                    System.out.print(courses.get(i).getTimes().get(j).toString().substring(0,2));
                    System.out.print(date.getHours());
                }
            }
        }

        model.addAttribute("courses",courses);

        System.out.println(courses);
        return "tutor/service";
    }



    @RequestMapping("/tutor/reserve/{id}")
    public String reserve(Model model, @PathVariable("id")Integer id){
        List<Course> courses = tutorService.getCourse();


        Date date = new Date();
        List<Time> allTimes = null;
        for(int i=0;i<courses.size();i++){
            allTimes = tutorService.getTimes(courses.get(i).getTeacher(),courses.get(i).getName());
            courses.get(i).setTimes(allTimes);
            courses.get(i).setLight(false);

            for(int j=0; j<courses.get(i).getTimes().size();j++){

                if(Integer.parseInt(courses.get(i).getTimes().get(j).toString().substring(0,2)) - date.getHours() <=1 && Integer.parseInt(courses.get(i).getTimes().get(j).toString().substring(0,2)) - date.getHours() >=0){
                    courses.get(i).setLight(true);
                    System.out.print(courses.get(i).getTimes().get(j).toString().substring(0,2));
                    System.out.println(date.getHours());
                }
            }

            if(courses.get(i).getId() == id){
                courses.get(i).setLight(false);
            }

        }
        model.addAttribute("courses",courses);
        return "tutor/service";
    }

    @PostMapping("/tutor/search")
//    @RequestMapping(value = "/article/search",method = RequestMethod.GET)
//    @ResponseBody
    public String search(Search search, Model model, HttpSession session){
        Date date = new Date();
        System.out.println(search);
        List<Course> courses;

        if(search.getType().equals("name")) {
            System.out.println(search.getContent());
            courses = tutorService.getByName(search.getContent());
        }
        else
            courses = tutorService.getByTeacher(search.getContent());


        List<Time> allTimes = null;
        for(int i=0;i<courses.size();i++){
            allTimes = tutorService.getTimes(courses.get(i).getTeacher(),courses.get(i).getName());
            courses.get(i).setTimes(allTimes);
            courses.get(i).setLight(false);

            for(int j=0; j<courses.get(i).getTimes().size();j++){

                if(Integer.parseInt(courses.get(i).getTimes().get(j).toString().substring(0,2)) - date.getHours() <=1 && Integer.parseInt(courses.get(i).getTimes().get(j).toString().substring(0,2)) - date.getHours() >=0){
                    courses.get(i).setLight(true);
                    System.out.print(courses.get(i).getTimes().get(j).toString().substring(0,2));
                    System.out.print(date.getHours());
                }
            }
        }

        model.addAttribute("courses",courses);

        System.out.println(courses);
        return "tutor/service::courses";
    }

}
