package com.agenciadeviagens.local.pedidos.controller;

import com.agenciadeviagens.global.interfaces.InterfaceController;
import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.clientes.service.ClienteService;
import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.local.pacotes.service.PacoteService;
import com.agenciadeviagens.local.pedidos.dto.PedidoDTO;
import com.agenciadeviagens.local.pedidos.service.PedidoService;
import com.agenciadeviagens.local.servicos.dto.ServicosDTO;
import com.agenciadeviagens.local.servicos.service.ServicosService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/pedido/ui")
public class PedidoController implements InterfaceController<PedidoDTO> {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;
    private final PacoteService pacoteService;
    private final ServicosService servicosService;
    public PedidoController(PedidoService pedidoService, ClienteService clienteService, PacoteService pacoteService, ServicosService servicosService) {
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
        this.pacoteService = pacoteService;
        this.servicosService = servicosService;
    }

    @Override
    @GetMapping("/criar")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView("pedidos/formulario");
        mv.addObject("pedido", new PedidoDTO());

        List<ClienteDTO> clienteDTOS = clienteService.listarTodos();
        List<ServicosDTO> servicosDTOS = servicosService.listarTodos();
        List<PacoteDTO> pacoteDTOS = pacoteService.listarTodos();

        mv.addObject("clientes", clienteDTOS);
        mv.addObject("servicos", servicosDTOS);
        mv.addObject("pacotes", pacoteDTOS);

        return mv;
    }

    @Override
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute PedidoDTO entidade) {
        try {
            pedidoService.salvar(entidade);
            return "redirect:/pedido/ui/todos";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @GetMapping("/todos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView();
        List<PedidoDTO> pedidoDTOS = pedidoService.listarTodos();
        System.out.println(pedidoDTOS);
        mv.setViewName("pedidos/listar-todos");
        mv.addObject("todosPedidos", pedidoDTOS);
        return mv;
    }

    @Override
    @GetMapping("/visualizar/{id}")
    public ModelAndView visualizar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        PedidoDTO pedidoDTO = pedidoService.buscarPorId(id);
        mv.setViewName("pedidos/visualizar");
        mv.addObject("pedido", pedidoDTO);
        return mv;
    }

    @Override
    public ModelAndView editar(Long id) {
        return null;
    }

    @Override
    public String atualizar(PedidoDTO entidade, HttpServletRequest request) {
        return "";
    }

    @Override
    public String deletar(Long id) {
        return "";
    }
}
