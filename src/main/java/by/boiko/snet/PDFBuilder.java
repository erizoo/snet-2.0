package by.boiko.snet;

import by.boiko.snet.model.User;
import by.boiko.snet.service.UserService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 */
@Controller
public class PDFBuilder extends AbstractITextPdfView {

    @Autowired
    private UserService userService;

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> listUsers = (List<User>) model.get("listBooks");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.now();
        String formattedDate = localDate.format(formatter);
        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 30f, Font.NORMAL, BaseColor.BLACK);
        Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 20f, Font.NORMAL, BaseColor.BLACK);
        Paragraph paragraph = new Paragraph("List of users", f);
        Paragraph paragraph2 = new Paragraph(String.valueOf(formattedDate), f2);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        doc.add(paragraph);
        doc.add(paragraph2);
        User user = new User();
        com.itextpdf.text.List list1 = new com.itextpdf.text.List(com.itextpdf.text.List.ORDERED);
        list1.setFirst(1);
        for (User row : listUsers) {
            user.setFirstName(row.getFirstName());
            user.setLastName(row.getLastName());
            String userSting = row.getFirstName() + " " + row.getLastName();
            list1.add(userSting);
        }
        doc.add(list1);
    }

}