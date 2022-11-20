package com.fran.controller;


import com.fran.mapper.CreditMapper;
import com.fran.mapper.GoodMapper;
import com.fran.mapper.TranMapper;
import com.fran.pojo.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Controller
public class ProductController {


    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private CreditMapper creditMapper;
    @Autowired
    private TranMapper tranMapper;
    @GetMapping("/products")
    public String products(Model model){

        List<Transaction> info = tranMapper.getTransactions();
        model.addAttribute("info",info);
        System.out.println(info);
        model.addAttribute("t","#");
        return "product/goods";
    }



    @RequestMapping("/pay")
    public String pay(Transaction transaction,Model model)
    {


        model.addAttribute("id",transaction.getId());
        model.addAttribute("price",transaction.getPrice());
        model.addAttribute("laomeng",transaction.getName());

        System.out.println(transaction.getId());
        System.out.println(transaction.getPrice());
        System.out.println(transaction.getName());
        return "payment/payPage";
    }


    @PostMapping("/check")
    public String check(Credit credit, Model model){
//        if(credit.name)
        Credit credit1 = creditMapper.get(credit.getNumber());
        if(credit1 == null){
            model.addAttribute("msg","Fail ! The number of credit card is not exist !");
            return "payment/result";
        }else{
            if(credit1.getName().equals(credit.getName()) && credit1.getCvv() == credit.getCvv()){
                model.addAttribute("msg","ok !");
                return "payment/result";
            }


            model.addAttribute("msg","Fail ! The Name or CVV is not right !");
            return "payment/result";
        }

    }




    @RequestMapping("/pay/finish")
    public String  finishPay(long id, Model model){

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id+"过来了");
        tranMapper.delete(id);

//
        return "redirect:/main.html";
    }


    @PostMapping("/good/search")
    public String search(Search search, Model model, HttpSession session){
        System.out.println(search);

        List<Transaction> info = tranMapper.getByName(search.getContent());

        model.addAttribute("info",info);
        System.out.println(info);
        model.addAttribute("t","#");
        return "product/goods::info";
    }

}
