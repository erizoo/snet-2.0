package by.boiko.snet.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/reports")
public class FileDownloadController
{
    @RequestMapping("/{fileName:.+}")
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response,
                                     @PathVariable("fileName") String fileName) throws FileNotFoundException, DocumentException {
        //If user is not authorized - he should be thrown out from here itself
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.open();
        document.add(new Paragraph("A Hello World PDF document."));
        document.close();
        writer.close();
        byte [] data = new byte[8192];
        //Authorized user will download the file
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/pdf/");
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file))
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);

            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().write(data);
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}