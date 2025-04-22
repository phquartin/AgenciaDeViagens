package com.agenciadeviagens.clientes.controller;

import com.agenciadeviagens.clientes.dto.ClienteDTO;
import com.agenciadeviagens.clientes.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/salvar")
    public void salvar(@RequestBody ClienteDTO clienteDTO) {
        clienteService.salvar(clienteDTO);
    }

    @GetMapping("/todos")
    public List<ClienteDTO> listarTodos(){
        return clienteService.listarTodos();
    }

}
