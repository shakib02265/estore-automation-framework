package utils;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;

public class PdfUtil {

    private static int counter = 1;


    public static void create(

            String type,

            String testName,

            String url,

            String status,

            long executionTime

    ) throws Exception {



        new java.io.File(
                "pdf")
                .mkdirs();



        Document document =
                new Document();



        PdfWriter.getInstance(

                document,

                new FileOutputStream(

                        "pdf/"
                                + testName
                                + ".pdf"
                )
        );



        document.open();



        document.add(

                new Paragraph(

                        "Test Number : TC-"

                                + String.format(
                                        "%03d",
                                        counter++
                                )
                )
        );



        document.add(

                new Paragraph(
                        "Type : "
                                + type
                )
        );



        document.add(

                new Paragraph(
                        "Test Name : "
                                + testName
                )
        );



        document.add(

                new Paragraph(
                        "URL : "
                                + url
                )
        );



        document.add(

                new Paragraph(
                        "Execution Time : "
                                + executionTime
                                + " ms"
                )
        );



        document.add(

                new Paragraph(
                        "Result : "
                                + status
                )
        );



        document.close();
    }
}