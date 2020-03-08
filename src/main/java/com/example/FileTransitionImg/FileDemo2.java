package com.example.FileTransitionImg;


import java.io.File;
import java.io.FileFilter;

public class FileDemo2 {
    private static String path = "F:\\学习视频";

    public static void main(String[] args) {
//        boolean bool = isFileExists(path);
//        System.out.println(bool);
        //listFilesDemo(path);
        //listFilesDemo2(path);

        File file = new File(path);
        fileDirectory(file);
    }

    /**
     * @param filePath 文件路径
     * @return true 不存在  false 存在
     */
    private static boolean isFileExists(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return false;
        }
        return true;
    }

    /**
     * 列出指定目录下所有文件  ，返回file []
     *
     * @param filePath
     */
    private static void listFilesDemo(String filePath) {
        File file = new File(filePath);
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    //列出指定目录下所有文件,返回File[]
    public static void listFilesDemo2(String filePath) {
        File file = new File(filePath);
        //用匿名内部类实现过滤的操作。
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // TODO Auto-generated method stub
                System.out.println("pathname---------:" + pathname);
                return pathname.toString().endsWith("txt");
            }
        });
        for (File f : files) {
            System.out.println(f);
        }
    }

    /**
     * 获取指定目录下的所有文件及子文件夹和文件目录 递归调用
     * @param file
     */
    private static void fileDirectory(File file) {
        //打印file 目录下文件夹路径
        System.out.println(file);
        //把获取到的文件夹保存File数组中
        File[] file1 = file.listFiles();
        for (File file2 : file1) {
            //判断是否为文件夹
            if (file2.isDirectory()) {
                fileDirectory(file2);
            } else {
                System.out.println(file2+"--文件："+file2.isFile());
            }
        }
    }
}
