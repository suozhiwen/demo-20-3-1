package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.FileToPdf.DocToPdf.docToPdf;
import static com.example.FileToPdf.ExcelToPdf.excelToPdf;
import static com.example.FileToPdf.PptToPdf.pptToPdf;
import static com.example.FileTransitionImg.Pdf2Img.tranfer;

@RestController
public class HelloController {

    @RequestMapping(value = "hello")
    public void hello() {
        String path1 = "D:/pdftestfile/word.doc";
        String path2 = "D:/pdftestfile/wordToPdf.pdf";
        String path3 = "D:/pdftestfile/excel.xlsx";
        String path4 = "D:/pdftestfile/excelToPdf.pdf";
        String path5 = "D:/pdftestfile/ppt.pptx";
        String path6 = "D:/pdftestfile/pptToPdf.pdf";
        String path = "D:/pdftestfile";
        docToPdf(path1, path2);
        tranfer(path2,path,1f);


        excelToPdf(path3, path4);
        tranfer(path4,path,1f);


        pptToPdf(path5, path6);
        tranfer(path6,path,1f);
    }
}
