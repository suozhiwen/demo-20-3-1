package com.example.FileToPdf;

public class out {

    public static void outMessage(String inPath,String outPath,long now,long old){
       double time = (now - old) / 1000.0;
        System.out.println("源文件："+inPath);
        System.out.println("现文件："+outPath);
        System.out.println("转换成功,共耗时：" + time+ "秒");
    }
}
