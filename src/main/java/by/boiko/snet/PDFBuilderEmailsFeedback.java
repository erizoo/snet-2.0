package by.boiko.snet;

import by.boiko.snet.model.Email;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 */
public class PDFBuilderEmailsFeedback extends AbstractITextPdfView {

    private org.joda.time.format.DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd-MM-yyyy");

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "inline; filename=" + "feedback_" + dateTimeFormatter.print(new LocalDate()) + ".pdf");
        List<Email> listEmails = (List<Email>) model.get("listEmails");

        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 30f, Font.NORMAL, BaseColor.BLACK);
        Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 20f, Font.NORMAL, BaseColor.BLACK);
        Font f3 = new Font(Font.FontFamily.HELVETICA, 9f, Font.NORMAL, BaseColor.BLACK);
        Paragraph paragraph = new Paragraph("List of feedback", f);
        Paragraph paragraph2 = new Paragraph(String.valueOf(dateTimeFormatter.print(new LocalDate())), f2);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        doc.add(paragraph);
        doc.add(paragraph2);
        paragraph = new Paragraph(" ");
        doc.add(paragraph);
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(110);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);

        table.addCell("#");
        table.addCell("Subject");
        table.addCell("Body");
        table.addCell("E-mail");
        table.addCell("Date");

        Email email = new Email();
        int i = 0;
        for (Email row : listEmails) {
            ++i;
            email.setFrom(row.getFrom());
            email.setBody(row.getBody());
            email.setCreatedTimestamp(row.getCreatedTimestamp());
            email.setSubject(row.getSubject());
            table.addCell(String.valueOf(i));
            table.addCell(new Paragraph(email.getFrom(), f3));
            table.addCell(new Paragraph(email.getSubject(), f3));
            table.addCell(new Paragraph(email.getBody(), f3));
            table.addCell(new Paragraph(String.valueOf(email.getCreatedTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))), f3));
        }
        doc.add(table);
    }

    @Override
    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
        document.addTitle("feedback_" + dateTimeFormatter.print(new LocalDate()) + ".pdf");
    }
}
