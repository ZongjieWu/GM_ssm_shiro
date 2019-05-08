package com.wzj.web.controller;

import com.wzj.enums.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;
import java.util.UUID;

@ApiIgnore
@RestController
@RequestMapping("/upload/image/")
public class UploadController {
    /**
     * 单文件上传  ，  保存文件后返回文件路径。
     *
     * @param file
     * @param session
     * */
    @RequestMapping("uploadImg")
    public static Map<String,Object> uploadImg(MultipartFile file,String baseCatalog, HttpSession session){
        //获得项目路径
        String path = session.getServletContext().getRealPath(baseCatalog);
        //把路径中的包括\\全部换成/
        path = path.replace("\\","/");
        //System.out.println("文件地址"+path);
        //获取文件名
        String fileName = file.getOriginalFilename();
        String fName = "";
        String suffix = "";
        if(fileName.indexOf(".")>=0){
            int  indexdot =  fileName.indexOf(".");
            suffix =  fileName.substring(indexdot);
            fName = fileName.substring(0,fileName.lastIndexOf("."));
            //使用UUID为文件重新命名，保证文件名唯一性
            fName = "file" + "_"  + UUID.randomUUID().toString().replace("-", "");
            fName =  fName  + suffix;
        }
        File targetFile = new File(path, fName);
        String resultPath = baseCatalog.substring(1,baseCatalog.length())+"/"+fName;
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.retrunSucessMsgData(resultPath);
    }

}
