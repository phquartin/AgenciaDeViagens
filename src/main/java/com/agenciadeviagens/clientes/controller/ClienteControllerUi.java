package com.agenciadeviagens.clientes.controller;

import com.agenciadeviagens.clientes.dto.ClienteDTO;
import com.agenciadeviagens.clientes.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cliente/ui")
public class ClienteControllerUi {

    private final ClienteService clienteService;
    public ClienteControllerUi(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/todos")
    public ModelAndView listarTodos(){
        ModelAndView mv = new ModelAndView("clientes/listar-todos");
        List<ClienteDTO> todosClientes = clienteService.listarTodos();
        mv.addObject("todosClientes", todosClientes);
        return mv;
    }

}
