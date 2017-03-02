package by.boiko.snet.controller;

import by.boiko.snet.model.User;
import by.boiko.snet.service.UserService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Controller
public class FileDownloadController {

    private int size;
    private static final String APPLICATION_PDF = "application/pdf";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/reports/users", method = RequestMethod.GET, produces = "application/pdf")
    @ResponseBody
    public Document toPdf() throws FileNotFoundException {
        User user = userService.getAllForId(1);
        String lastName = user.getLastName();
        String firstName = user.getFirstName();

        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        return document;
    }

    @RequestMapping(value = "/b", method = RequestMethod.GET, produces = APPLICATION_PDF)
    public
    @ResponseBody
    HttpEntity<byte[]> downloadB(User user) throws IOException, DocumentException {
//        cratedFirstPdf();
        File file = getFile();
        byte[] document = FileCopyUtils.copyToByteArray(file);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "pdf"));
        header.set("Content-Disposition", "inline; filename=" + file.getName());
        header.setContentLength(document.length);
        return new HttpEntity<byte[]>(document, header);
    }

//    private void cratedFirstPdf() throws FileNotFoundException, DocumentException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate localDate = LocalDate.now();
//        String formattedDate = localDate.format(formatter);
//        Document doc = new Document();
//        PdfWriter.getInstance(doc, new FileOutputStream("D:\\users" + formattedDate + ".pdf"));
//        doc.open();
//        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 30f, Font.NORMAL, BaseColor.BLACK);
//        Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 20f, Font.NORMAL, BaseColor.BLACK);
//        Paragraph paragraph = new Paragraph("List of users", f);
//        Paragraph paragraph2 = new Paragraph(String.valueOf(formattedDate), f2);
//        paragraph.setAlignment(Element.ALIGN_CENTER);
//        paragraph2.setAlignment(Element.ALIGN_CENTER);
//        doc.add(paragraph);
//        doc.add(paragraph2);
//        User user = new User();
//        List list1 = new List(List.ORDERED);
//        list1.setFirst(1);
//            for(User row : userService.getNames()){
//                user.setFirstName(row.getFirstName());
//                user.setLastName(row.getLastName());
//                String userSting = row.getFirstName() + " " + row.getLastName();
//                list1.add(userSting);
//            }
//        doc.add(list1);
//        doc.close();
//    }

    private File getFile() throws FileNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.now();
        String formattedDate = localDate.format(formatter);
        File file = new File("D:\\users" + formattedDate + ".pdf");
        if (!file.exists()) {
            throw new FileNotFoundException("file with path: " + "D:\\users" + formattedDate + ".pdf" + " was not found.");
        }
        return file;
    }

    @RequestMapping(value = "/reports/users", method = RequestMethod.GET)
    public ModelAndView downloadPdf() {
        // create some sample data

        User user = new User();
        java.util.List<User> listBooks = new ArrayList<User>();
        for(User row : userService.getNames()){
            user.setFirstName(row.getFirstName());
            user.setLastName(row.getLastName());
            String userSting = row.getFirstName() + " " + row.getLastName();
            listBooks.add(new User(row.getFirstName(), row.getLastName()));
        }


        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("pdfView", "listBooks", listBooks);
    }

}