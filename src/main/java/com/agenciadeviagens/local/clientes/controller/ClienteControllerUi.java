package com.agenciadeviagens.local.clientes.controller;

import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.clientes.service.ClienteService;
import com.agenciadeviagens.local.clientes.validation.ClienteException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/visualizar/{id}")
    public ModelAndView visualizar(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("clientes/visualizar");
        mv.addObject("cliente", clienteService.buscarPorId(id));
        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("clientes/editar");
        mv.addObject("cliente", clienteService.buscarPorId(id));
        return mv;
    }
    @PostMapping("/atualizar/{id}")
    public String atualizar(@ModelAttribute("cliente") ClienteDTO cliente, HttpServletRequest request) {
        try {
            clienteService.update(cliente.getId(), cliente);
            return "redirect:/cliente/ui/visualizar/" + cliente.getId();
        } catch (ClienteException e) {
            request.setAttribute("cliente", cliente);
            throw e;
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.excluir(id);
        return "redirect:/cliente/ui/todos";
    }

}
