package com.wzj.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传工具类
 * 
 */
public class UploadUtil {

	
	/**
	 * 单文件上传  ，  保存文件后返回文件路径。 
	 * 
	 * @param file
	 * @param session
	 * @param folderName
	 * */
	public static String uploadFile(MultipartFile file,HttpSession session,String folderName){
		//获得项目路径
		String path = session.getServletContext().getRealPath("/upload/"+folderName);
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
            fName = "file" + "_"  +UUID.randomUUID().toString().replace("-", "");  
            fName =  fName  + suffix;  
        }  
        File targetFile = new File(path, fName);    
        String resultPath = "/"+folderName+"/"+fName;
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }    
        //保存    
        try {    
        	file.transferTo(targetFile);    
        } catch (Exception e) {    
            e.printStackTrace();    
        }   
        
        return resultPath;
     
     }
	
	
	/**
	 * 多文件上传  ，  保存文件后返回文件路径。  以逗号分隔
	 * 
	 * @param files
	 * @param session
	 * @param folderName
	 * */
	public static String uploadFiles(List<MultipartFile> files,HttpSession session,String folderName){
		//获得项目路径
		String path = session.getServletContext().getRealPath("/images/upload/"+folderName);
		//String path = session.getServletContext().getContextPath()+"/images/upload/"+folderName;
		//把路径中的包括\\全部换成/
		path = path.replace("\\","/");
		System.out.println("文件地址"+path);
        List<String> mylist = new ArrayList<String>();
        //遍历
        for(MultipartFile item:files){
	        String fileName = item.getOriginalFilename();
	        String fName = "";  
	        String suffix = "";  
	        if(fileName.indexOf(".")>=0){  
	            int  indexdot =  fileName.indexOf(".");  
	            suffix =  fileName.substring(indexdot);  
	            fName = fileName.substring(0,fileName.lastIndexOf("."));  
	            fName = "file" + "_"  +UUID.randomUUID().toString().replace("-", "");  	//为文件重新命名
	            fName =  fName  + suffix;  
	        }  
	        File targetFile = new File(path, fName);    
	        mylist.add("upload/"+folderName+"/"+fName);
	        if(!targetFile.exists()){    
	            targetFile.mkdirs();    
	        }    
	        //保存    
	        try {    
	        	item.transferTo(targetFile);    
	        } catch (Exception e) {    
	            e.printStackTrace();    
	        }   
        }
     if(mylist.size()==0) {
    	 return null;
     }else {
	     StringBuffer result = new StringBuffer();
	     boolean first = true;
	      for(String str:mylist) {
	    	  //第一个不拼接","
	    	  if(first) {
	    		  first = false;
	    	  }else {
	    		  result.append(",");
	    	  }
	    	  result.append(str);
	      }
			return result.toString();
	     }
     }
}
