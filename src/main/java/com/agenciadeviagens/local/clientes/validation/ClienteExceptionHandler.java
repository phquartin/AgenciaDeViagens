package com.agenciadeviagens.local.clientes.validation;

import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ClienteExceptionHandler {
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
