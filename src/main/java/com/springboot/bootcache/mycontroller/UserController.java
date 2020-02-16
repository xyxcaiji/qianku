package com.springboot.bootcache.mycontroller;

import com.springboot.bootcache.bean.User;
import com.springboot.bootcache.service.UserService;
import com.springboot.bootcache.util.AliyunOSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller()
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AliyunOSSUtil aliyunOSSUtil;
//    @ResponseBody
//    @GetMapping("/{id}")
//    public String getByid(@PathVariable("id") Integer id)
//    {
//        User byid = userService.getByid(id);
//        return  "success";
//    }
    @ResponseBody
    @RequestMapping("/user/insert")
    public String insert(HttpServletRequest request, @RequestParam(value = "user_head",required =false) MultipartFile file) throws IOException {
        //userService.insrt(user);
        //user对象接受对象数据
        User user = new User();
        user.setUser_sex(request.getParameter("user_sex"));
        //照片上传后返回的url路径
        String newPath = null;
        try {
            newPath = aliyunOSSUtil.uploadBlog(file, request);
        } catch (Exception e) {
//            userService.de
            e.printStackTrace();
        }


        user.setUser_head(newPath);
        userService.insrt(user);
        System.out.println(user.toString());
        return user.getUser_head();

    }
}
