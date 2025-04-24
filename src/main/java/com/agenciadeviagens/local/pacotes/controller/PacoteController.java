package com.agenciadeviagens.local.pacotes.controller;

import com.agenciadeviagens.global.interfaces.InterfaceController;
import com.agenciadeviagens.global.interfaces.InterfaceService;
import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.local.pacotes.service.PacoteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pacote/ui")
public class PacoteController implements InterfaceController<PacoteDTO> {

    private final PacoteService pacoteService;
    public PacoteController(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }

    @Override
    public ModelAndView criar() {
        return null;
    }
    @Override
    public String salvar(PacoteDTO entidade) {
        return "";
    }

    @Override
    @GetMapping("/todos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView();
        List<PacoteDTO> pacote = pacoteService.listarTodos();

        mv.setViewName("pacotes/listar-todos");
        mv.addObject("todosPacotes", pacote);

        return mv;
    }

    @Override
    @GetMapping("/visualizar/{id}")
    public ModelAndView visualizar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        PacoteDTO pacote = pacoteService.buscarPorId(id);
        mv.setViewName("pacotes/visualizar");
        mv.addObject("pacote", pacote);
        return mv;
    }

    @Override
    public ModelAndView editar(Long id) {
        return null;
    }

    @Override
    public String atualizar(PacoteDTO entidade, HttpServletRequest request) {
        return "";
    }

    @Override
    public String deletar(Long id) {
        return "";
    }
}
