package com.springboot.bootcache.mycontroller;

import com.aliyun.oss.OSSClient;
import com.springboot.bootcache.bean.User;
import com.springboot.bootcache.util.AliyunOSSUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;

/**
 * Created by lightClouds917
 * Date 2018/2/7
 * Description:文件上传
 */
@Controller
public class UploadController {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    AliyunOSSUtil aliyunOSSUtil;
    /**
     * 文件上传
     * @param file
     */
/*    @ResponseBody
    @RequestMapping(value = "upload",method = RequestMethod.POST)*/
    public String uploadBlog(@RequestParam(value = "file",required =false)MultipartFile file, HttpServletRequest request){
        //判断格式是否正确
         String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".gif", ".png"};
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(),
                    type)) {
                isLegal = true;
                break;
            }
        }
        //如果不符合预定义的格式，直接中断程序
            if (isLegal==false)
            {
                logger.error("上传文件格式失败");
                System.exit(0);
            }
        logger.info("============>文件上传");
        try {

            if(null != file){
                String filename = file.getOriginalFilename();
              //  System.out.println("filename"+filename);
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    //上传到OSS
                    String finalPath = aliyunOSSUtil.upload(newFile);
                    logger.info("路径=======>"+finalPath);
                    String path = System.getProperty("user.dir");
                    String filepath=path+File.separator+file.getOriginalFilename();
                    File file1=new File(filepath);
                    if(file1.exists())
                    {
                        file1.delete();
                    }else {
                        logger.info("============>删除遗留在项目中的文件失败");
                    }
                    if(finalPath!=null)
                    {
                        return finalPath;
                    }
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


//    //图片下载
//    @ResponseBody
//    @RequestMapping("/url")
//    public String getUrl(AliyunOSSUtil aliyunOSSUtil) {
//        // 设置URL过期时间为10年  3600l* 1000*24*365*10
//        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
//        // 生成URL
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//        URL url = ossClient.generatePresignedUrl(bucketName, finalPath, expiration);
//        if (url != null) {
//            return url.toString();
//        }
//        return null;
//    }

}