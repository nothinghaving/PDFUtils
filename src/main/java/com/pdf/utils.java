package com.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

/**
 * @Description: TODO
 * @author: mzd
 * @date: 2024年09月10日 9:12
 */

public class utils {
    public static void main(String[] args) throws IOException {
        PDDocument pdDocument = PDDocument.load(new File("C:\\Users\\Administrator\\Desktop\\新建文件夹\\未命名1.pdf"));
        for (int i = 0; i < pdDocument.getNumberOfPages(); i++) {
            PDPage page = pdDocument.getPage(i);
            PDPageContentStream pdPageContentStream = new PDPageContentStream(pdDocument, page, PDPageContentStream.AppendMode.APPEND, true, true);
            //设置字体和字号
            pdPageContentStream.setFont(PDType1Font.HELVETICA_OBLIQUE,30);
            //设置透明度
            pdPageContentStream.setNonStrokingColor(200,200,200);
            //添加文本水印
            pdPageContentStream.beginText();
            pdPageContentStream.newLineAtOffset(200,500);//设置水印位置
            pdPageContentStream.showText("mazhengdong");//设置水印内容
            pdPageContentStream.endText();
            pdPageContentStream.close();//关闭流
        }
        //保存修改后的pdf
        pdDocument.save(new File("C:\\Users\\Administrator\\Desktop\\新建文件夹\\test.pdf"));
        pdDocument.close();
    }
}
