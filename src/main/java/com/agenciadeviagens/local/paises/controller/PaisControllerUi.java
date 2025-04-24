package com.agenciadeviagens.local.paises.controller;

import com.agenciadeviagens.global.interfaces.InterfaceController;
import com.agenciadeviagens.local.paises.dto.PaisDTO;
import com.agenciadeviagens.local.paises.service.PaisService;
import com.agenciadeviagens.local.paises.validation.PaisException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pais/ui")
public class PaisControllerUi implements InterfaceController<PaisDTO> {

    private final PaisService paisService;
    public PaisControllerUi(PaisService paisService) {
        this.paisService = paisService;
    }


    @Override
    @GetMapping("/criar")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView("paises/formulario");
        mv.addObject("pais", new PaisDTO());
        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("pais") PaisDTO paisDTO) {
        paisService.salvar(paisDTO);
        return "redirect:/pais/ui/todos";
    }

    @Override
    @GetMapping("/todos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView("paises/listar-todos");
        mv.addObject("todosPaises", paisService.listarTodos());
        return mv;
    }

    @Override
    @GetMapping("/visualizar/{id}")
    public ModelAndView visualizar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("paises/visualizar");
        mv.addObject("pais", paisService.buscarPorId(id));
        return mv;
    }

    @Override
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("paises/editar");
        mv.addObject("pais", paisService.buscarPorId(id));
        return mv;
    }
    @Override
    @PostMapping("/atualizar/{id}")
    public String atualizar(@ModelAttribute PaisDTO entidade, HttpServletRequest request) {
        try {
            paisService.update(entidade.getId(), entidade);
            return "redirect:/pais/ui/visualizar/" + entidade.getId();
        } catch (PaisException e){
            request.setAttribute("pais", entidade);
            throw e;
        }
    }

    @Override
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        paisService.excluir(id);
        return "redirect:/pais/ui/todos";
    }
}
