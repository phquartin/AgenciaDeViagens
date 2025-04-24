package com.agenciadeviagens.local.pedidos.mapper;

import com.agenciadeviagens.local.clientes.mapper.ClienteMapper;
import com.agenciadeviagens.local.pacotes.mapper.PacoteMapper;
import com.agenciadeviagens.local.pedidos.dto.PedidoDTO;
import com.agenciadeviagens.local.pedidos.dto.PedidoPacoteDTO;
import com.agenciadeviagens.local.pedidos.model.PedidoModel;
import com.agenciadeviagens.local.servicos.mapper.ServicosMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PedidoPacoteMapper {

    private final ClienteMapper clienteMapper;
    private final ServicosMapper servicosMapper;

    public PedidoPacoteMapper(ClienteMapper clienteMapper, ServicosMapper servicosMapper) {
        this.clienteMapper = clienteMapper;
        this.servicosMapper = servicosMapper;
    }

    public PedidoModel map(PedidoPacoteDTO pedidoDTO) {
        PedidoModel pedido = new PedidoModel();
        pedido.setId(pedidoDTO.getId());

        // Convertendo DTO -> Model usando os outros mappers
        pedido.setCliente(clienteMapper.map(pedidoDTO.getCliente()));
        pedido.setServicos(
                pedidoDTO.getServicos() != null ?
                        pedidoDTO.getServicos().stream()
                                .map(servicosMapper::map)
                                .collect(Collectors.toList())
                        : null
        );

        return pedido;
    }

    public PedidoPacoteDTO map(PedidoModel pedidoModel) {
        PedidoPacoteDTO pedidoDTO = new PedidoPacoteDTO();
        pedidoDTO.setId(pedidoModel.getId());

        // Convertendo Model -> DTO usando os outros mappers
        pedidoDTO.setCliente(clienteMapper.map(pedidoModel.getCliente()));
        pedidoDTO.setServicos(
                pedidoModel.getServicos() != null ?
                        pedidoModel.getServicos().stream()
                                .map(servicosMapper::map)
                                .collect(Collectors.toList())
                        : null
        );

        return pedidoDTO;
    }
}
