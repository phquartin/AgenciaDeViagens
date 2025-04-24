package com.agenciadeviagens.local.servicos.controller;

import com.agenciadeviagens.global.interfaces.InterfaceController;
import com.agenciadeviagens.local.servicos.dto.ServicosDTO;
import com.agenciadeviagens.local.servicos.service.ServicosService;
import com.agenciadeviagens.local.servicos.validation.ServicosException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/servico/ui")
public class ServicosControllerUi implements InterfaceController<ServicosDTO> {

    private final ServicosService servicosService;
    public ServicosControllerUi(ServicosService servicosService) {
        this.servicosService = servicosService;
    }


    @Override
    @GetMapping("/criar")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("servicos/formulario");
        mv.addObject("servico", new ServicosDTO());
        return mv;
    }
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute ServicosDTO entidade, HttpServletRequest request) {
        try {
            servicosService.salvar(entidade);
            return "redirect:/servico/ui/todos";
        } catch (ServicosException e) {
            request.setAttribute("servico", entidade);
            throw e;
        }
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
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        ServicosDTO servico = servicosService.buscarPorId(id);
        mv.setViewName("servicos/editar");
        mv.addObject("servico", servico);
        return mv;
    }
    @Override
    @PostMapping("/atualizar/{id}")
    public String atualizar(@ModelAttribute ServicosDTO entidade, HttpServletRequest request) {
        try{
            servicosService.update(entidade.getId(), entidade);
            return "redirect:/servico/ui/todos";
        } catch (ServicosException e){
            request.setAttribute("servico", entidade);
            throw e;
        }
    }

    @Override
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        servicosService.excluir(id);
        return "redirect:/servico/ui/todos";
    }

    @Override
    public String salvar(ServicosDTO entidade) {
        return "";
    }

}
