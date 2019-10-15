package com.commons.commons.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author zhaomengxia
 * @create 2019/10/14 11:53
 */
public class FileTest {


    public static void main(String[] args) {
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter("test2.txt",true);
            for (int i = 0; i <100 ; i++) {
                fileWriter.write("zhaomengxia\r\n");
                if (i%10==0){
                    fileWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //这一步进行判断，防止空指针异常
            if (fileWriter!=null) {
                try {
                    //在关闭前会做flush处理
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
