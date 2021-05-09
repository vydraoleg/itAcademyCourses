package by.azot.asutp.rest.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorHandlerController implements ErrorController {

    public final static String ERRORPATH = "/error";

    @ExceptionHandler(Exception.class)
    @RequestMapping(ERRORPATH)
    @ResponseBody
    public ModelAndView handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");  //<html><body>

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", String.format("<h2>Error Page</h2><div>Status code: <b>%s</b></div>"
                        + "<div>Exception Message: <b>%s</b></div>",
                statusCode, exception == null ? "N/A" : exception.getMessage()));
        mav.setViewName(ERRORPATH);
        return mav;
    }

    @Override
    public String getErrorPath() {
        return ERRORPATH;
    }

}
