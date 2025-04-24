package com.agenciadeviagens.local.servicos.validation;

import com.agenciadeviagens.local.destinos.dto.DestinoDTO;
import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.local.pacotes.validation.PacoteException;
import com.agenciadeviagens.local.servicos.dto.ServicosDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ServicosExceptionHandler {
    @ExceptionHandler(ServicosException.class)
    public ModelAndView handleServicosException(ServicosException ex, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String url = request.getRequestURI();

        ServicosDTO servico = (ServicosDTO) request.getAttribute("servico");
        if (url.contains("/atualizar/")) {
            mv.setViewName("servicos/editar");
            mv.addObject("erro", ex.getMessage());
            mv.addObject("servico", servico);
            return mv;
        }
        mv.setViewName("servicos/formulario");
        mv.addObject("erro", ex.getMessage());
        if (servico == null) {
            servico = new ServicosDTO();
        }
        mv.addObject("servico", servico);
        return mv;
    }
}
