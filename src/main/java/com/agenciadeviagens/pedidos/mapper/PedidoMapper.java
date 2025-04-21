package com.agenciadeviagens.pedidos.mapper;

import com.agenciadeviagens.pedidos.dto.PedidoDTO;
import com.agenciadeviagens.pedidos.model.PedidoModel;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
    public PedidoModel map(PedidoDTO pedidoDTO) {
        PedidoModel pedido = new PedidoModel();
        pedido.setId(pedidoDTO.getId());
        pedido.setCliente(pedidoDTO.getCliente());
        pedido.setPacote(pedidoDTO.getPacote());
        pedido.setServicos(pedidoDTO.getServicos());
        return pedido;
    }
    public PedidoDTO map(PedidoModel pedidoModel) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedidoModel.getId());
        pedidoDTO.setCliente(pedidoModel.getCliente());
        pedidoDTO.setPacote(pedidoModel.getPacote());
        pedidoDTO.setServicos(pedidoModel.getServicos());
        return pedidoDTO;
    }
}
