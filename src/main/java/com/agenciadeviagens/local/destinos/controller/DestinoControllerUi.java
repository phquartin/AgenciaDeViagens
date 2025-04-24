package com.agenciadeviagens.local.destinos.controller;

import com.agenciadeviagens.global.interfaces.InterfaceController;
import com.agenciadeviagens.local.destinos.dto.DestinoDTO;
import com.agenciadeviagens.local.destinos.service.DestinoService;
import com.agenciadeviagens.local.destinos.validation.DestinoException;
import com.agenciadeviagens.local.paises.dto.PaisDTO;
import com.agenciadeviagens.local.paises.service.PaisService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/destino/ui")
public class DestinoControllerUi implements InterfaceController<DestinoDTO> {

    private final DestinoService destinoService;
    private final PaisService paisService;

    public DestinoControllerUi(DestinoService destinoService, PaisService paisService) {
        this.destinoService = destinoService;
        this.paisService = paisService;
    }

    @GetMapping("/criar")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView("destinos/formulario");
        mv.addObject("destino", new DestinoDTO());

        // Adicionando lista de países ao modelo
        List<PaisDTO> todosPaises = paisService.listarTodos();
        mv.addObject("todosPaises", todosPaises);

        return mv;
    }

    @Override
    public String salvar(DestinoDTO entidade) {
        return "";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("destino") DestinoDTO destino, HttpServletRequest request) {
        try {
            destinoService.salvar(destino);
            return "redirect:/destino/ui/todos";
        } catch (DestinoException e) {
            request.setAttribute("destino", destino); // Para garantir que esteja acessível no handler
            throw e;
        }
    }


    @GetMapping("/todos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("destinos/listar-todos");
        List<DestinoDTO> todosDestinos = destinoService.listarTodos();
        mv.addObject("todosDestinos", todosDestinos);
        return mv;
    }

    @GetMapping("/visualizar/{id}")
    public ModelAndView visualizar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("destinos/visualizar");
        mv.addObject("destino", destinoService.buscarPorId(id));
        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("destinos/editar");
        mv.addObject("destino", destinoService.buscarPorId(id));
        return mv;
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@ModelAttribute("destino") DestinoDTO destino, HttpServletRequest request) {
        try {
            destinoService.update(destino.getId(), destino);
            return "redirect:/destino/ui/visualizar/" + destino.getId();
        } catch (DestinoException e) {
            request.setAttribute("destino", destino);
            throw e;
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        destinoService.excluir(id);
        return "redirect:/destino/ui/todos";
    }
}
