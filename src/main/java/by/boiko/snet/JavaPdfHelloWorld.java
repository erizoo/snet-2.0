package by.boiko.snet;


import org.yogthos.JsonPDF;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;

public class JavaPdfHelloWorld {


    public static void main(String[] args) throws Exception {

        String jsonDoc1 = "[{}, [\"paragraph\", \"hello world\"]]";
        String jsonDoc2 = "[{\"pages\":true,\"orientation\":\"landscape\"}, [\"paragraph\", \"hello world\"]]";

        JsonPDF.writeToFile(jsonDoc1, "out.pdf");

        JsonPDF.writeToStream(new ByteArrayInputStream(jsonDoc2.getBytes()),
                new FileOutputStream("outstream.pdf"));
    }

}
