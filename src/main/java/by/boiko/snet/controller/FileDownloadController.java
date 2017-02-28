package by.boiko.snet.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/download")
public class FileDownloadController
{
    @RequestMapping("/pdf/{fileName:.+}")
    public void downloadPDFResource( HttpServletRequest request,
                                     HttpServletResponse response,
                                     @PathVariable("fileName") String fileName,
                                     @RequestHeader String referer) throws DocumentException, FileNotFoundException {

        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\ITextTest.pdf"));
        writer.open();
        document.open();
        document.add(new Paragraph("sdgsdgsdg"));
        document.close();
        writer.close();

        //Authorized user will download the file
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/pdf/");
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file))
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                PdfWriter.getInstance(document, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}