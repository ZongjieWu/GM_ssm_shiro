package com.wzj.web;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
@Controller
public class DbOprationUtil {
    @Autowired
    private DruidDataSource dataSource;

    public void backupData(){
        // 数据库导出
        String user = "root"; // 数据库帐号
        String password = "root"; // 数据库密码
        String database = "hdrc"; // 需要备份的数据库名
        String filepath = "D:\\dbtest\\mysql.sql"; // 需要备份到的地址
        String stmt1 = "mysqldump " + database + " -u " + user + " -p" + password + " --result-file=" + filepath;
        try {
            Runtime.getRuntime().exec(stmt1);
            System.out.println("数据已导出到文件" + filepath + "中");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reStoreData(){
        File newfile = new File("D:\\dbtest\\hdrc.sql");
        Resource resource = new FileSystemResource(newfile);
        EncodedResource resourceDelegate = new EncodedResource(resource);
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ScriptUtils.executeSqlScript(conn, resource);


    }

    public static void main(String[] args) {
//        DbOprationUtil.backupData();
       new DbOprationUtil().reStoreData();
    }

}
