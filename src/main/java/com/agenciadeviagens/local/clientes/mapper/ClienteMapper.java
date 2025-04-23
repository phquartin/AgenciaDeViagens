package com.agenciadeviagens.local.clientes.mapper;

import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.clientes.model.ClienteModel;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteModel map(ClienteDTO ClienteDTO) {
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setId(ClienteDTO.getId());
        clienteModel.setNome(ClienteDTO.getNome());
        clienteModel.setTelefone(ClienteDTO.getTelefone());
        clienteModel.setEmail(ClienteDTO.getEmail());
        clienteModel.setTipo(ClienteDTO.getTipo());
        clienteModel.setDocumento(ClienteDTO.getDocumento());
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
        return clienteDTO;
    }

}
