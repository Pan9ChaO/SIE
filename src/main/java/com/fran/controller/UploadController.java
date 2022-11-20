package com.fran.controller;

import com.fran.entity.DataJson;
import com.fran.pojo.Transaction;
import com.fran.service.TranService;
import com.fran.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * 作者: DL代先生
 * 日期: 2021/4/29
 * 时间: 11:15
 * 描述: 上传的controller！
 * 内容:
 */
@Controller
//@RequestMapping("upload")
public class UploadController {
    @Autowired
    private TranService tranService;

    @GetMapping("/tran")
    public String tran(){
        return "tran/trans";
    }



    @RequestMapping("/upload/image")
    @ResponseBody
    public DataJson image(MultipartFile file){
        //调用工具类完成文件上传
        System.out.println(file);
        String imagePath = UploadUtils.upload(file);
        System.out.println(imagePath);
        DataJson dataJson = new DataJson();
        if (imagePath != null){
            //创建一个HashMap用来存放图片路径
            HashMap hashMap = new HashMap();
            hashMap.put("src",imagePath);
            dataJson.setCode(1);
            dataJson.setMsg("上传成功");
            dataJson.setData(hashMap);
        }else{
            dataJson.setCode(0);
            dataJson.setMsg("上传失败");
        }
        return dataJson;
    }


    @RequestMapping("/upload/addImage")
    @ResponseBody
    public String addImage(Transaction transaction, HttpSession session){
        //获得图片地址和图片描述
        /*
            这里我们只做打印的操作，实际上，我们应该在这里调用
            方法，把图片地址和图片的描述加入到数据库中，但是这些
            相信大家已经回了，所以，就不再写了。
         */
        long id = System.currentTimeMillis();
        Object authorId =session.getAttribute("loginStu");
        System.out.println(authorId);
        transaction.setAuthorId(Integer.parseInt((String) authorId));
        transaction.setId(id);
        System.out.println(transaction.toString());
        tranService.save(transaction);



        return "1";
    }

    @RequestMapping("deleteImage")
    @ResponseBody
    public String deleteImage(){
        UploadUtils.delete("84e15dddb4284fc8a4877c93bcc9d81f-dl.jpg");
        return "1";
    }
}
