package com.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: TODO
 * @author: mzd
 * @date: 2024年09月10日 11:26
 */

public class ItexUtils {
    public static void main(String[] args) throws IOException, DocumentException {
        //读取原始PDF文件
        PdfReader pdfReader = new PdfReader("C:\\Users\\Administrator\\Desktop\\新建文件夹\\未命名1.pdf");
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("C:\\Users\\Administrator\\Desktop\\新建文件夹\\testItex.pdf"));
        //获取文件页数
        int number = pdfReader.getNumberOfPages();
        for (int j = 1; j <= number; j++) {
            PdfContentByte underContent = pdfStamper.getUnderContent(j);
            underContent.beginText();
            underContent.setColorFill(BaseColor.BLUE);//设置颜色
            underContent.setFontAndSize(BaseFont.createFont(),30);
            underContent.showTextAligned( PdfContentByte.ALIGN_CENTER,"mazhengdong",200,500,45);
            underContent.endText();
        }
       pdfStamper.close();
        pdfReader.close();
    }
}
