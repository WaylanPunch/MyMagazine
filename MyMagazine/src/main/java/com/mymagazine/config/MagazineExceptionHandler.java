package com.mymagazine.config;

import com.mymagazine.exception.TipException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@CrossOrigin
//@ControllerAdvice
public class MagazineExceptionHandler {

   /* @ExceptionHandler
    public ModelAndView magazineExceptionHandler(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("magazineException", exception.getMessage());
        modelAndView.setViewName("magazineerror");
        return modelAndView;
    }*/
}
