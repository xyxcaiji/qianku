package com.springboot.bootcache.mycontroller;


import com.springboot.bootcache.bean.Nursing;
import com.springboot.bootcache.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class NurseController {

    //自动注入
    @Autowired
    NurseService nurseService;
    //增加护士
    @ResponseBody
    @GetMapping("/insertNurse")
    public String insertNurse(Nursing nursing)
    {
        System.out.println("insert"+nursing);
        nurseService.insert(nursing);

        return "1";
    }
    //通过护士id获得护士信息
    @ResponseBody
    @GetMapping("/selectNurseByName")
    public Nursing insertNurse(@RequestParam("nurse_name")String nuser_name)
    {
        Nursing nursing = nurseService.selectByName(nuser_name);
        System.out.println(nursing);
        return nursing;
    }

    //搜索所有的护士信息
    @ResponseBody
    @GetMapping("/nurseSelectAll")
    public ArrayList<Nursing> selectAll()
    {
        ArrayList<Nursing> nursings = nurseService.selectAll();
        //model.addAttribute("nursings",nursings);
        return nursings;
    }
    //删除护士信息
    @ResponseBody
    @GetMapping("/deleteNurseById")
    public  String deleteByid(@RequestParam("id")Integer id)
    {
        nurseService.deleteByid(id);
        return "1";
    }

    //更新护士信息
    @ResponseBody
    @GetMapping("/updateNurse")
    public String update(Nursing nursing)
    {
        nurseService.updat(nursing);
        return "1";
    }

}
