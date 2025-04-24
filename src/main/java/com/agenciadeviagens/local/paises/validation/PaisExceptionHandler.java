package com.agenciadeviagens.local.paises.validation;

import com.agenciadeviagens.local.paises.dto.PaisDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PaisExceptionHandler {
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(PaisException.class)
    public ModelAndView handlePaisException(PaisException ex, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String url = request.getRequestURI();
        if (url.contains("/atualizar/")) {
            PaisDTO pais = (PaisDTO) request.getAttribute("pais");
            mv.setViewName("paises/editar");
            mv.addObject("erro", ex.getMessage());
            mv.addObject("pais", pais);
            return mv;
        }
        mv.setViewName("paises/formulario");
        mv.addObject("erro", ex.getMessage());
        mv.addObject("pais", new PaisDTO());
        return mv;
    }
}
