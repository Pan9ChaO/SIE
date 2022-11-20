package com.fran.controller;


import com.fran.pojo.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RestController
public class EmailController {
    @Value("${spring.mail.username}")
    private String from;



    @Autowired
    private JavaMailSender javaMailSender;

//    @RequestMapping("/send")
//    public String send(String to,String subject,String context){
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(context);
//        javaMailSender.send(message);
//        return "success";
//    }

    @RequestMapping("/sendHtml")
    public String sendHtml(String to,String subject,String context) throws MessagingException {
        context="<p style=\"background-color:red; height: 50px; width: 500px\"> this is p</p>";

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(context,true);
        javaMailSender.send(mimeMessage);
        return "SUCCESS";

    }

    @RequestMapping("/sendAttachment")
    public String sendA(String to,String subject,String context,String filePath) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(context);
        mimeMessageHelper.setFrom(from);

        FileSystemResource fileSystemResource = new FileSystemResource(new File("e:\\Users\\77078\\Desktop\\微信图片_20221029215816.jpg"));
        String filename = fileSystemResource.getFilename();
        mimeMessageHelper.addAttachment(filename,fileSystemResource);
        javaMailSender.send(mimeMessage);
        return "success";

    }

    @RequestMapping("/send/test")
    public String test(Mail mail) throws MessagingException {


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        String[] email = mail.getName().toString().split(";");


        for(int i=0;i<email.length;i++){
            if(i==0){
                email[0] = email[0].substring(1, email[0].length());
            }
            if(email[i].contains("]")){
                if(email[i].length() == 1){
                    continue;
                }else{
                    email[i] = email[i].substring(0,email[i].length()-1);
                }
            }
            mimeMessageHelper.setTo(email[i]);
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setText(mail.getMessage(),true);
            mimeMessageHelper.setFrom(from);
            javaMailSender.send(mimeMessage);
//            System.out.println(email[i]);

        }

//        for(int i=0;i<)

        return "1";
    }

}
