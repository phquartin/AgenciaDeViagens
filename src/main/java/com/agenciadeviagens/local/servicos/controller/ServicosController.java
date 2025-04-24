package com.agenciadeviagens.local.servicos.controller;

import com.agenciadeviagens.global.interfaces.InterfaceController;
import com.agenciadeviagens.local.servicos.dto.ServicosDTO;
import com.agenciadeviagens.local.servicos.service.ServicosService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/servico/ui")
public class ServicosController implements InterfaceController<ServicosDTO> {

    private final ServicosService servicosService;
    public ServicosController(ServicosService servicosService) {
        this.servicosService = servicosService;
    }


    @Override
    public ModelAndView criar() {
        return null;
    }
    @Override
    public String salvar(ServicosDTO entidade) {
        return "";
    }

    @Override
    @GetMapping("/todos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView();
        List<ServicosDTO> todosServicos = servicosService.listarTodos();

        mv.setViewName("servicos/listar-todos");
        mv.addObject("todosServicos", todosServicos);
        return mv;
    }

    @Override
    @GetMapping("/visualizar/{id}")
    public ModelAndView visualizar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("servicos/visualizar");
        mv.addObject("servico", servicosService.buscarPorId(id));
        return mv;
    }

    @Override
    public ModelAndView editar(Long id) {
        return null;
    }
    @Override
    public String atualizar(ServicosDTO entidade, HttpServletRequest request) {
        return "";
    }

    @Override
    public String deletar(Long id) {
        return "";
    }
}
