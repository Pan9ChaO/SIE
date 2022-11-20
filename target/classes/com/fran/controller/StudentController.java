package com.fran.controller;


import com.fran.mapper.QuestionDao;
import com.fran.mapper.StudentMapper;
import com.fran.pojo.Question;
import com.fran.pojo.Student;
import com.fran.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private QuestionDao questionDao;


    @PostMapping("/regAddStu")
    public String addStu(Student student, Model model) {
        Student stu = studentService.get(student.getId());
        if (stu != null) {

            model.addAttribute("msg", "Student already exists !");
            Collection<Question> questions = questionDao.getQuestions();
            model.addAttribute("questions", questions);

            return "register";
        }


        System.out.println(student);
        studentService.save(student);
        model.addAttribute("msg", " success !");
        return "login_stu";
    }

    @PostMapping("/checkAnswer")
    public String checkAnswer(@RequestParam("id") String id, @RequestParam("question") String question, @RequestParam("answer") String answer, Model model) {


//
        Student student = studentService.get(Integer.parseInt(id));


        if (student == null) {
            model.addAttribute("msg", "Student not exist !");
            Collection<Question> questions = questionDao.getQuestions();
            model.addAttribute("questions", questions);
            return "find/check";
        }


        System.out.println(id + "," + student.getId());
        System.out.println(Integer.parseInt(id) == student.getId());
        System.out.println(question.equals(student.getQuestion()));
        System.out.println(question);
        System.out.println(student.getQuestion());
        System.out.println(answer.equals(student.getAnswer()));
        if (Integer.parseInt(id) == student.getId() && Integer.parseInt(question) == student.getQuestion() && answer.equals(student.getAnswer())) {
            model.addAttribute("idNum", id);
            return "find/alter";
        } else {
            model.addAttribute("msg", "answer is incorrect !");
            Collection<Question> questions = questionDao.getQuestions();
            model.addAttribute("questions", questions);
            return "find/check";
        }


    }


    @PostMapping("/changeAnswer")
    public String changeAnswer(@RequestParam("id") String id,@RequestParam("pwd") String pwd, Model model) {


      int idNum = Integer.parseInt(id);
      studentService.update(idNum,pwd);
        String pwd2 =  studentService.get(idNum).getPwd();
        System.out.println(pwd2);

        model.addAttribute("msg", "Already change");
        return "login_stu";
    }


}
