package com.agenciadeviagens.clientes.controller;

import com.agenciadeviagens.clientes.dto.ClienteDTO;
import com.agenciadeviagens.clientes.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cliente/ui")
public class ClienteControllerUi {

    private final ClienteService clienteService;
    public ClienteControllerUi(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/criar")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView("clientes/formulario");
        mv.addObject("cliente", new ClienteDTO());
        return mv;
    }
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("cliente") ClienteDTO cliente, RedirectAttributes redirectAttributes) {
        clienteService.salvar(cliente);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso.");
        return "redirect:/cliente/ui/todos";
    }



    @GetMapping("/todos")
    public ModelAndView listarTodos(){
        ModelAndView mv = new ModelAndView("clientes/listar-todos");
        List<ClienteDTO> todosClientes = clienteService.listarTodos();
        mv.addObject("todosClientes", todosClientes);
        return mv;
    }

}
