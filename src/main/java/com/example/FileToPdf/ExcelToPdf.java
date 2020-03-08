package com.example.FileToPdf;

import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;

import java.io.File;
import java.io.FileOutputStream;

import static com.example.FileToPdf.License.getExcelLicense;
import static com.example.FileToPdf.out.outMessage;

public class ExcelToPdf {

    public static void excelToPdf(String inPath, String outPath) {
        if (!getExcelLicense()) {          // 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        try {
            long old = System.currentTimeMillis();
            File pdfFile = new File(outPath);// 输出路径
            Workbook wb = new Workbook(inPath);// 原始excel路径
            PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
            pdfSaveOptions.setOnePagePerSheet(true);
            FileOutputStream fileOS = new FileOutputStream(pdfFile);
            wb.save(fileOS, SaveFormat.PDF);
            fileOS.close();
            long now = System.currentTimeMillis();
            outMessage(inPath, outPath, now, old);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
