package com.agenciadeviagens.global.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, HttpServletRequest request) {
        ErrorResponse erro = new ErrorResponse(
                ex.getMessage(),
                500,
                LocalDateTime.now(),
                request.getRequestURI()
        );
        ModelAndView mv = new ModelAndView("error/template");
        mv.addObject("erro", erro);
        return mv;
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ModelAndView handleInternalServerError(HttpServerErrorException.InternalServerError ex, HttpServletRequest request) {
        ErrorResponse erro = new ErrorResponse(
                ex.getMessage(),
                500,
                LocalDateTime.now(),
                request.getRequestURI()
        );
        ModelAndView mv = new ModelAndView("error/template");
        mv.addObject("erro", erro);
        return mv;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView handleDataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request) {
        ErrorResponse erro = new ErrorResponse(
                ex.getMessage(),
                500,
                LocalDateTime.now(),
                request.getRequestURI()
        );
        ModelAndView mv = new ModelAndView("error/template");
        mv.addObject("erro", erro);
        return mv;
    }

    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ModelAndView handleRecursoNaoEncontrado(RecursoNaoEncontrado ex, HttpServletRequest request) {
        ErrorResponse erro = new ErrorResponse(
                ex.getMessage(),
                404,
                LocalDateTime.now(),
                request.getRequestURI()
        );

        ModelAndView mv = new ModelAndView("error/template");
        mv.addObject("erro", erro);
        return mv;
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ModelAndView handleNoResourceFoundException(HttpServletRequest request) {
        ErrorResponse erro = new ErrorResponse(
                "Not Found",
                404,
                LocalDateTime.now(),
                request.getRequestURI()
        );

        ModelAndView mv = new ModelAndView("error/template");
        mv.addObject("erro", erro);
        return mv;
    }

}
