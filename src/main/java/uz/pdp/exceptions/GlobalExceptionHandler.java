package uz.pdp.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BookNotFoundException.class})
    public ModelAndView error_404(HttpServletRequest request, BookNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("error/404");
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.addObject("url", request.getRequestURL());
        return modelAndView;
    }

    @ExceptionHandler({Exception.class})
    public ModelAndView error_404(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error/404");
        modelAndView.addObject("message", ex.getMessage()+" | "+ex.getClass().getSimpleName());
        modelAndView.addObject("url", request.getRequestURL());
        return modelAndView;
    }

}
