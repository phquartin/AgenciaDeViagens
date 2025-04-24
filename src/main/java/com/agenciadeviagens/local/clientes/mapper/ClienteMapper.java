package com.agenciadeviagens.local.clientes.mapper;

import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.clientes.model.ClienteModel;
import com.agenciadeviagens.local.pedidos.dto.PedidoDTO;
import com.agenciadeviagens.local.pedidos.mapper.PedidoMapper;
import com.agenciadeviagens.local.pedidos.model.PedidoModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    private final PedidoMapper pedidoMapper;
    public ClienteMapper(PedidoMapper pedidoMapper) {
        this.pedidoMapper = pedidoMapper;
    }

    public ClienteModel map(ClienteDTO ClienteDTO) {
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(ClienteDTO.getId());
        clienteModel.setNome(ClienteDTO.getNome());
        clienteModel.setTelefone(ClienteDTO.getTelefone());
        clienteModel.setEmail(ClienteDTO.getEmail());
        clienteModel.setTipo(ClienteDTO.getTipo());
        clienteModel.setDocumento(ClienteDTO.getDocumento());

        List<PedidoModel> pedidos = ClienteDTO.getPedidos().stream().map(pedidoMapper::map).collect(Collectors.toList());
        clienteModel.setPedidos(pedidos);

        return clienteModel;
    }
    public ClienteDTO map(ClienteModel ClienteModel) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(ClienteModel.getId());
        clienteDTO.setNome(ClienteModel.getNome());
        clienteDTO.setTelefone(ClienteModel.getTelefone());
        clienteDTO.setEmail(ClienteModel.getEmail());
        clienteDTO.setTipo(ClienteModel.getTipo());
        clienteDTO.setDocumento(ClienteModel.getDocumento());

        List<PedidoDTO> pedidos = ClienteModel.getPedidos().stream().map(pedidoMapper::map).collect(Collectors.toList());
        clienteDTO.setPedidos(pedidos);

        return clienteDTO;
    }

}
