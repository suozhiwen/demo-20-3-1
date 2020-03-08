package com.example.FileToPdf;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;

import static com.example.FileToPdf.License.getWordLicense;
import static com.example.FileToPdf.out.outMessage;

public class DocToPdf {


    public static void docToPdf(String inPath, String outPath) {
        if (!getWordLicense()) {
            // 验证License 若不验证则转化出的pdf文档会有水印产生
            System.out.println(inPath + ",解析水印失败，请重试");
            return;
        }
        try {
            long old = System.currentTimeMillis();
            File file = new File(outPath); // 新建一个pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(inPath); // 验证License 是将要被转化的word文档

            System.out.println("开始解析word文档" + inPath);
            doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX,
            // OOXML, RTF HTML,
            // OpenDocument,
            // PDF, EPUB, XPS,
            // SWF 相互转换
            long now = System.currentTimeMillis();
            os.close();
            outMessage(inPath, outPath, now, old);
        } catch (Exception e) {
            System.out.println(inPath + "转换失败，请重试");
            e.printStackTrace();
        }
    }
}
