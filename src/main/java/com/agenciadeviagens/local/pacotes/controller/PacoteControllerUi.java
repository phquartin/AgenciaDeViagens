package com.agenciadeviagens.local.pacotes.controller;

import com.agenciadeviagens.global.interfaces.InterfaceController;
import com.agenciadeviagens.local.destinos.dto.DestinoDTO;
import com.agenciadeviagens.local.destinos.service.DestinoService;
import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.local.pacotes.service.PacoteService;
import com.agenciadeviagens.local.pacotes.validation.PacoteException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pacote/ui")
public class PacoteControllerUi implements InterfaceController<PacoteDTO> {

    private final PacoteService pacoteService;
    private final DestinoService destinoService;
    public PacoteControllerUi(PacoteService pacoteService, DestinoService destinoService) {
        this.pacoteService = pacoteService;
        this.destinoService = destinoService;
    }

    @Override
    @GetMapping("/criar")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pacotes/formulario");
        mv.addObject("pacote", new PacoteDTO());
        List<DestinoDTO> destinos = destinoService.listarTodos();
        mv.addObject("todosDestinos", destinos);
        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute PacoteDTO entidade, HttpServletRequest request) {
        try{
            pacoteService.salvar(entidade);
            return "redirect:/pacote/ui/todos";
        } catch (PacoteException e){
            request.setAttribute("pacote", entidade);
            throw e;
        }
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
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        PacoteDTO pacote = pacoteService.buscarPorId(id);
        mv.setViewName("pacotes/editar");
        mv.addObject("pacote", pacote);
        return mv;
    }
    @Override
    @PostMapping("/atualizar/{id}")
    public String atualizar(@ModelAttribute PacoteDTO entidade, HttpServletRequest request) {
        try{
            pacoteService.update(entidade.getId(), entidade);
            return "redirect:/pacote/ui/visualizar/" + entidade.getId();
        } catch (PacoteException e){
            request.setAttribute("pacote", entidade);
            throw e;
        }
    }

    @Override
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        pacoteService.excluir(id);
        return "redirect:/pacote/ui/todos";
    }

    @Override
    public String salvar(PacoteDTO entidade) {
        return "";
    }

}
