package com.springboot.bootcache.mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 管理文件上传与下载的类
 */
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class PicController {

    static SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
//    @RequestMapping("/upload")
    public static String upload(@RequestParam(value = "file",required =false) MultipartFile file, HttpServletRequest request) throws IOException {

        String format= sf.format(new Date());

        String oldName = file.getOriginalFilename();
//        String path = System.getProperty("user.dir");
//        System.out.println(path);
        File directory = new File("src/main/resources/image");
        String courseFile = directory.getCanonicalPath();

        //建立文件的路径
        String newPath=courseFile+File.separator+format;
        System.out.println(newPath);
        //file.transferTo(new File(newPath));
        File file1=new File(newPath);
        //如果文件路径为空，就创建一个文件目录
        if(!file1.isDirectory()) {
            file1.mkdirs();
        }
        try {

            file.transferTo(new File(file1,oldName));
            return newPath+File.separator+oldName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "forward:error";
    }

    @ResponseBody
    @RequestMapping("/download")
    public String downLoad()
    {
        return "false";
    }
}
