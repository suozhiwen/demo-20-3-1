package com.example.FileToPdf;

import java.io.InputStream;

public class License {

    public static boolean getExcelLicense() {
        boolean result = false;
        try {
            InputStream is = ExcelToPdf.class.getClassLoader().getResourceAsStream("license.xml"); //  license.xml应放在..\WebRoot\WEB-INF\classes路径下
            com.aspose.cells.License aposeLic = new com.aspose.cells.License();
            aposeLic.setLicense(is);
            result = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean getWordLicense() {
        boolean result = false;
        try {
            InputStream is = DocToPdf.class.getClassLoader().getResourceAsStream("\\license.xml");
            com.aspose.words.License aposeLic = new com.aspose.words.License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static boolean getPptLicense() {
        boolean result = false;
        try {
            InputStream is = PptToPdf.class.getClassLoader().getResourceAsStream("\\license.xml");
            com.aspose.slides.License aposeLic = new com.aspose.slides.License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
