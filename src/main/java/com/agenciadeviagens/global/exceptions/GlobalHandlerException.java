package com.agenciadeviagens.global.exceptions;

import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.clientes.validation.ClienteException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView handleClienteInvalidoException(ClienteException ex, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String url = request.getRequestURI();
        if (url.contains("/atualizar/")) {
            ClienteDTO cliente = (ClienteDTO) request.getAttribute("cliente");
            mv.setViewName("clientes/editar");
            mv.addObject("erro", ex.getMessage());
            mv.addObject("cliente", cliente);
        }
        else {
            mv.setViewName("clientes/formulario");
            mv.addObject("cliente", new ClienteDTO());
        }
        mv.addObject("erro", ex.getMessage());
        return mv;
    }
}
