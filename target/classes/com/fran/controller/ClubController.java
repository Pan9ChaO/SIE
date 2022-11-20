package com.fran.controller;


import com.alibaba.fastjson.JSON;
import com.fran.pojo.*;
import com.fran.service.ClubService;
import com.fran.service.GoodService;
import com.fran.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class ClubController {

    @Autowired
    private ClubService clubService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/club/list")
    public String  clubList(Model model, HttpSession session){
        List<Club> clubs = clubService.getClubs();

        model.addAttribute("clubs",clubs);
        String s = "/";
        Object id = session.getAttribute("loginStu");
        int stuId =  Integer.parseInt(id.toString());
        model.addAttribute("stuId",stuId);
        model.addAttribute("s",s);
        System.out.println(stuId);

        List<Integer> clubIds =  clubService.getClubId(stuId);

        for(int i=0;i<clubs.size();i++){
            if(clubIds.contains(clubs.get(i).getId())){
                clubs.get(i).setContain(false);
            }else{
                clubs.get(i).setContain(true);
            }
        }

        System.out.println( clubs);
       return "club/clubtt";




    }

    @GetMapping("/club/add/{Id}/{cId}")
    public String add(@PathVariable("Id")Integer Id,@PathVariable("cId")Integer cId,Model model,HttpSession session){
        clubService.save(Id,cId);
        clubService.increase(cId);






        List<Club> clubs = clubService.getClubs();
        model.addAttribute("clubs",clubs);
        String s = "/";
        Object id = session.getAttribute("loginStu");
        int stuId =  Integer.parseInt(id.toString());
        model.addAttribute("stuId",stuId);
        model.addAttribute("s",s);
        System.out.println(stuId);

        List<Integer> clubIds =  clubService.getClubId(stuId);

        for(int i=0;i<clubs.size();i++){
            if(clubIds.contains(clubs.get(i).getId())){
                clubs.get(i).setContain(false);
            }else{
                clubs.get(i).setContain(true);
            }
        }

        System.out.println( clubs);
        return "club/clubtt";


    }
    @GetMapping("/clubList")
    public String clubList(){
        return "/club/clubList";
    }


    @PostMapping("/addClub")
    public String addClub(Club club,Model model,HttpSession session){
        Object id = session.getAttribute("loginStu");
        int stuId =  Integer.parseInt(id.toString());

        if(clubService.getClubRecent(stuId, club.getName()) == -1) {


            clubService.create(club.getName(), 1, stuId, club.getDes());
            club.setId(clubService.getClubRecent(stuId, club.getName()));
            clubService.save(stuId, club.getId());


            System.out.println(club);



            List<Club> clubs = clubService.getClubs();
            model.addAttribute("clubs",clubs);
            String s = "/";

            model.addAttribute("stuId",stuId);
            model.addAttribute("s",s);
            System.out.println(stuId);

            List<Integer> clubIds =  clubService.getClubId(stuId);

            for(int i=0;i<clubs.size();i++){
                if(clubIds.contains(clubs.get(i).getId())){
                    clubs.get(i).setContain(false);
                }else{
                    clubs.get(i).setContain(true);
                }
            }

            System.out.println( clubs);
            return "club/clubtt";
        }else{
            model.addAttribute("msg","Club has existed !");





            List<Club> clubs = clubService.getClubs();

            model.addAttribute("clubs",clubs);
            String s = "/";

            model.addAttribute("stuId",stuId);
            model.addAttribute("s",s);
            System.out.println(stuId);

            List<Integer> clubIds =  clubService.getClubId(stuId);

            for(int i=0;i<clubs.size();i++){
                if(clubIds.contains(clubs.get(i).getId())){
                    clubs.get(i).setContain(false);
                }else{
                    clubs.get(i).setContain(true);
                }
            }

            System.out.println( clubs);
            return "club/clubtt";
        }


    }

    @PostMapping("/club/search")
    public String search(Search search, Model model, HttpSession session){
        System.out.println(search);

        List<Club> clubs;

        if(search.getType().equals("name")) {
            System.out.println(search.getContent());
            clubs = clubService.getByName(search.getContent());
        }

        else
            clubs = clubService.getByPresident(search.getContent());



        model.addAttribute("clubs",clubs);
        String s = "/";
        Object id = session.getAttribute("loginStu");
        int stuId =  Integer.parseInt(id.toString());
        model.addAttribute("stuId",stuId);
        model.addAttribute("s",s);
        System.out.println(stuId);

        List<Integer> clubIds =  clubService.getClubId(stuId);

        for(int i=0;i<clubs.size();i++){
            if(clubIds.contains(clubs.get(i).getId())){
                clubs.get(i).setContain(false);
            }else{
                clubs.get(i).setContain(true);
            }
        }

        System.out.println( clubs);
        return "club/clubtt::clubs";
    }


}
