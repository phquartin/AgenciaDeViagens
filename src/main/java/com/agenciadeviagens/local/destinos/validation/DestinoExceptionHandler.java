package com.agenciadeviagens.local.destinos.validation;

import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.clientes.validation.ClienteException;
import com.agenciadeviagens.local.destinos.dto.DestinoDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DestinoExceptionHandler {
    @ExceptionHandler(DestinoException.class)
    public ModelAndView handleClienteInvalidoException(DestinoException ex, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String url = request.getRequestURI();
        if (url.contains("/atualizar/")) {
            DestinoDTO destino = (DestinoDTO) request.getAttribute("destino");
            mv.setViewName("destinos/editar");
            mv.addObject("erro", ex.getMessage());
            mv.addObject("destino", destino);
            return mv;
        }
        mv.setViewName("destinos/formulario");
        mv.addObject("erro", ex.getMessage());
        mv.addObject("destino", new DestinoDTO());
        return mv;
    }
}
