package com.springboot.bootcache.mycontroller;

import com.springboot.bootcache.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestController {

    @RequestMapping(value = {"/","/login1"})
    public String login(Model model)
    {
        model.addAttribute("user",new User());
        return "login";
    }

}
