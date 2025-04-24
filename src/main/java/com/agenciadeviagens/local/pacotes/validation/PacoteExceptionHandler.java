package com.agenciadeviagens.local.pacotes.validation;

import com.agenciadeviagens.local.destinos.dto.DestinoDTO;
import com.agenciadeviagens.local.destinos.service.DestinoService;
import com.agenciadeviagens.local.destinos.validation.DestinoException;
import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
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
public class PacoteExceptionHandler {

    private final DestinoService destinoService;

    public PacoteExceptionHandler(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(PacoteException.class)
    public ModelAndView handlePacoteException(PacoteException ex, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String url = request.getRequestURI();

        List<DestinoDTO> todosDestinos = destinoService.listarTodos();
        mv.addObject("todosDestinos", todosDestinos);
        PacoteDTO pacote = (PacoteDTO) request.getAttribute("pacote");
        if (url.contains("/atualizar/")) {
            mv.setViewName("pacotes/editar");
            mv.addObject("erro", ex.getMessage());
            mv.addObject("pacote", pacote);
            return mv;
        }
        mv.setViewName("pacotes/formulario");
        mv.addObject("erro", ex.getMessage());
        if (pacote == null) {
            pacote = new PacoteDTO();
        }
        mv.addObject("pacote", pacote);
        return mv;
    }
}
