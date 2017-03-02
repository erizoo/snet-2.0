package by.boiko.snet;

import by.boiko.snet.model.User;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 */

public class PDFBuilder extends AbstractITextPdfView {

    private org.joda.time.format.DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd-MM-yyyy");

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "inline; filename=" + "users_" + dateTimeFormatter.print(new LocalDate()) + ".pdf");
        List<User> listUsers = (List<User>) model.get("listBooks");

        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 30f, Font.NORMAL, BaseColor.BLACK);
        Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 20f, Font.NORMAL, BaseColor.BLACK);
        Paragraph paragraph = new Paragraph("List of users", f);
        Paragraph paragraph2 = new Paragraph(String.valueOf(dateTimeFormatter.print(new LocalDate())), f2);
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

    @Override
    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
        document.addTitle("users_" + dateTimeFormatter.print(new LocalDate()) + ".pdf");
    }
}