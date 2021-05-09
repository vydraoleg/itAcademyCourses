package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.services.IUtilService;
import by.azot.asutp.rest.api.IControllerUrl;
import by.azot.asutp.web.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UtilController implements IControllerUrl {

    @Autowired
    private IUtilService utilService;

    @GetMapping("/book/{isbn}")
    public ModelAndView searchBook(@PathVariable String isbn) {
        ModelAndView modelAndView = new ModelAndView();
        BookDetails details = utilService.getBookByIsbn(isbn);
        modelAndView.setViewName("bookPage");
        modelAndView.addObject("book", details);
        return modelAndView;
    }
}
