package com.springboot.bootcache.mycontroller;

import com.springboot.bootcache.bean.User;
import com.springboot.bootcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class Denglu {

    @Autowired
    UserService userService;

    @PostMapping("/denglu")
    public String dengLu(HttpServletRequest request)
    {

        String username = request.getParameter("user_name");
        String password = request.getParameter("user_password");
        ArrayList<User> users = userService.selectAll();
        System.out.println(users);
        for(User user:users)
        {
            if(user.getUser_name().equals(username)&&user.getUser_password().equals(password)) {
                HttpSession session = request.getSession();
                String user_name = user.getUser_name();
                session.setAttribute("user_name",user_name);
                return "show";
            }
        }
        return "login";
    }
    //注册用户用的controller
    @PostMapping("/zhuce")
    public String zhuce(User user) {
//            response.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = response.getWriter();
        //如果这个用户再数据库里面已经有了 就注册失败
        ArrayList<User> users = userService.selectAll();
        System.out.println(users);
        for(User u1:users)
        {
            if(u1.getUser_name().equals(user.getUser_name())) {
                return "fail.html";
            }
        }
        //否则就注册
        userService.insert(user);
        return "success";
    }

}
