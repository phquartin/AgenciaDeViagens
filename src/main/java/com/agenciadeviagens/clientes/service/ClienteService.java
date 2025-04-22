package com.agenciadeviagens.clientes.service;

import com.agenciadeviagens.clientes.dto.ClienteDTO;
import com.agenciadeviagens.clientes.mapper.ClienteMapper;
import com.agenciadeviagens.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public void salvar(ClienteDTO clienteDTO) {
        //TODO: Exceptions


        clienteRepository.save(clienteMapper.map(clienteDTO));

    }

    public List<ClienteDTO> listarTodos(){
        return clienteRepository.findAll().stream()
                .map(clienteMapper::map)
                .collect(Collectors.toList());
    }

}
