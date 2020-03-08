package com.example.FileToPdf;

import com.aspose.slides.Presentation;

import java.io.File;
import java.io.FileOutputStream;

import static com.example.FileToPdf.License.getPptLicense;
import static com.example.FileToPdf.out.outMessage;

public class PptToPdf {

    public static void pptToPdf(String inPath, String outPath) {
        if (!getPptLicense()) {          // 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        try {
            long old = System.currentTimeMillis();
            File pdfFile = new File(outPath);// 输出路径
            FileOutputStream os = new FileOutputStream(pdfFile);
            //原始路径
            Presentation pres = new Presentation(inPath);
            pres.save(os, com.aspose.slides.SaveFormat.Pdf);
            os.close();
            long now = System.currentTimeMillis();
            outMessage(inPath, outPath, now, old);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
