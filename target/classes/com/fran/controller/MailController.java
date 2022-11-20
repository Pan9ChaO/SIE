package com.fran.controller;


import com.fran.pojo.Club;
import com.fran.pojo.Student;
import com.fran.service.ClubService;
import com.fran.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
public class MailController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClubService clubService;


    @GetMapping("/send")
    public String email(Model model, HttpSession session){

        int loginStu= Integer.parseInt((String) session.getAttribute("loginStu")) ;
        System.out.println(loginStu);
        List<Student> students = studentService.getAll();
        for(int i=0;i< students.size();i++){
           if(students.get(i).getId() == loginStu){
               students.remove(i);
           }
        }

        model.addAttribute("students",students);

        List<Club> clubs = clubService.getClubs();
        for(int i=0;i<clubs.size(); i++){
            List<Integer> studentsId = clubService.getStudentId(clubs.get(i).getId());
            if(studentsId.indexOf(loginStu) == -1){

                continue;
            }
            for(int j=0;j<studentsId.size();j++){
                Student stu = studentService.get(studentsId.get(j));
                if(stu.getId() == loginStu){
                    continue;
                }
                clubs.get(i).add(stu);
            }
        }




        model.addAttribute("clubs",clubs);
        System.out.println(clubs);

        return "mail/send";
    }




}
