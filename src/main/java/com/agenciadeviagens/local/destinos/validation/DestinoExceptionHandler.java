package com.agenciadeviagens.local.destinos.validation;

import com.agenciadeviagens.local.destinos.dto.DestinoDTO;
import com.agenciadeviagens.local.paises.dto.PaisDTO;
import com.agenciadeviagens.local.paises.service.PaisService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DestinoExceptionHandler {

    private final PaisService paisService;

    public DestinoExceptionHandler(PaisService paisService) {
        this.paisService = paisService;
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(DestinoException.class)
    public ModelAndView handleDestinoException(DestinoException ex, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String url = request.getRequestURI();
        List<PaisDTO> todosPaises = paisService.listarTodos();
        mv.addObject("todosPaises", todosPaises);
        if (url.contains("/atualizar/")) {
            DestinoDTO destino = (DestinoDTO) request.getAttribute("destino");
            mv.setViewName("destinos/editar");
            mv.addObject("erro", ex.getMessage());
            mv.addObject("destino", destino);
            return mv;
        }
        mv.setViewName("destinos/formulario");
        mv.addObject("erro", ex.getMessage());
        DestinoDTO destino = (DestinoDTO) request.getAttribute("destino");
        if (destino == null) {
            destino = new DestinoDTO();
        }
        mv.addObject("destino", destino);
        return mv;
    }
}
