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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/reports/users", method = RequestMethod.GET)
    public ModelAndView downloadPdf() {
        User user = new User();
        java.util.List<User> listBooks = new ArrayList<User>();
        for(User row : userService.getNames()){
            user.setFirstName(row.getFirstName());
            user.setLastName(row.getLastName());
            String userSting = row.getFirstName() + " " + row.getLastName();
            listBooks.add(new User(row.getFirstName(), row.getLastName()));
        }
        return new ModelAndView("pdfView", "listBooks", listBooks);
    }

}