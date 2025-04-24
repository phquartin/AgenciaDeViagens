package com.agenciadeviagens.local.pedidos.mapper;

import com.agenciadeviagens.local.pacotes.mapper.PacoteMapper;
import com.agenciadeviagens.local.pedidos.dto.PedidoClienteDTO;
import com.agenciadeviagens.local.pedidos.model.PedidoModel;
import com.agenciadeviagens.local.servicos.mapper.ServicosMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PedidoClienteMapper {

    private final PacoteMapper pacoteMapper;
    private final ServicosMapper servicosMapper;

    public PedidoClienteMapper(PacoteMapper pacoteMapper, ServicosMapper servicosMapper) {
        this.pacoteMapper = pacoteMapper;
        this.servicosMapper = servicosMapper;
    }

    public PedidoModel map(PedidoClienteDTO pedidoDTO) {
        PedidoModel pedido = new PedidoModel();
        pedido.setId(pedidoDTO.getId());

        // Convertendo DTO -> Model usando os outros mappers
        pedido.setPacote(pacoteMapper.map(pedidoDTO.getPacote()));
        pedido.setServicos(
                pedidoDTO.getServicos() != null ?
                        pedidoDTO.getServicos().stream()
                                .map(servicosMapper::map)
                                .collect(Collectors.toList())
                        : null
        );

        return pedido;
    }

    public PedidoClienteDTO map(PedidoModel pedidoModel) {
        PedidoClienteDTO pedidoDTO = new PedidoClienteDTO();
        pedidoDTO.setId(pedidoModel.getId());

        // Convertendo Model -> DTO usando os outros mappers
        pedidoDTO.setPacote(pacoteMapper.map(pedidoModel.getPacote()));
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
