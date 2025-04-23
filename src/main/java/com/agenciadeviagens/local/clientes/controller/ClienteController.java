package com.agenciadeviagens.local.clientes.controller;

import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.clientes.service.ClienteService;
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

    @GetMapping("/id/{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.excluir(id);
    }

}
