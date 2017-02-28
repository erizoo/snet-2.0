package by.boiko.snet;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JavaPdfHelloWorld {

    private Document document = new Document();

    {
        PdfWriter writer = null;
        try {
            writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
        document.open();
        try {
            document.add(new Paragraph("A Hello World PDF document."));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
        if (writer != null) {
            writer.close();
        }
    }

}
