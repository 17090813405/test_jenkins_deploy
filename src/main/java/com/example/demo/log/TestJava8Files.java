package com.example.demo.log;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author daizhichao
 * @date 2018/12/15
 */
public class TestJava8Files {
    public static void main(String[] args) {
        Path fpath = Paths.get("C:/Users/xykj/Desktop/事件日志.log");
        //创建文件
//        if (!Files.exists(fpath)) {
//            try {
//                Files.createFile(fpath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        //创建BufferedWriter
//        try {
//            BufferedWriter bfw = Files.newBufferedWriter(fpath);
//            bfw.write("Files类的API:newBufferedWriter");
//            bfw.flush();
//            bfw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //创建BufferedReader
        try {
            BufferedReader bfr = Files.newBufferedReader(fpath);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                System.out.println(line);
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
