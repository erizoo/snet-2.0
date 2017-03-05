package by.boiko.snet;

import by.boiko.snet.model.Email;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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

        response.setHeader("Content-Disposition", "inline; filename=" + "users_" + dateTimeFormatter.print(new LocalDate()) + ".pdf");
        List<Email> listEmails = (List<Email>) model.get("listEmails");

        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 30f, Font.NORMAL, BaseColor.BLACK);
        Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 20f, Font.NORMAL, BaseColor.BLACK);
        Paragraph paragraph = new Paragraph("List of feedback", f);
        Paragraph paragraph2 = new Paragraph(String.valueOf(dateTimeFormatter.print(new LocalDate())), f2);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        doc.add(paragraph);
        doc.add(paragraph2);
        PdfPTable table = new PdfPTable(8);
        for(int aw = 0; aw < 16; aw++){
            table.addCell("hi");
        }
        doc.add(table);
    }

    @Override
    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
        document.addTitle("users_" + dateTimeFormatter.print(new LocalDate()) + ".pdf");
    }
}
