package com.agenciadeviagens.exceptions;

import com.agenciadeviagens.clientes.dto.ClienteDTO;
import com.agenciadeviagens.clientes.validation.ClienteException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @ExceptionHandler(ClienteException.class)
    public ModelAndView handleClienteInvalidoException(ClienteException ex) {
        ModelAndView mv = new ModelAndView("clientes/formulario");
        mv.addObject("erro", ex.getMessage());
        mv.addObject("cliente", new ClienteDTO());
        return mv;
    }
}
