package com.agenciadeviagens.local.pedidos.controller;

import com.agenciadeviagens.global.interfaces.InterfaceController;
import com.agenciadeviagens.local.pedidos.dto.PedidoDTO;
import com.agenciadeviagens.local.pedidos.service.PedidoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class PedidoController implements InterfaceController<PedidoDTO> {

    private final PedidoService pedidoService;
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Override
    public ModelAndView criar() {
        return null;
    }

    @Override
    public String salvar(PedidoDTO entidade) {
        return "";
    }

    @Override
    @GetMapping("/todos")
    public ModelAndView listarTodos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pedido/listar");
        return mv;
    }

    @Override
    public ModelAndView visualizar(Long id) {
        return null;
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
