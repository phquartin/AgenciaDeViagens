package com.agenciadeviagens.local.clientes.service;

import com.agenciadeviagens.global.interfaces.InterfaceService;
import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.clientes.mapper.ClienteMapper;
import com.agenciadeviagens.local.clientes.model.ClienteModel;
import com.agenciadeviagens.local.clientes.repository.ClienteRepository;
import com.agenciadeviagens.local.clientes.validation.ClienteException;
import com.agenciadeviagens.local.clientes.validation.ClienteValidation;
import com.agenciadeviagens.global.exceptions.RecursoNaoEncontrado;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService implements InterfaceService<ClienteDTO> {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public void salvar(ClienteDTO cliente) {
        ClienteValidation.validarCampos(cliente);
        try {
            clienteRepository.save(clienteMapper.map(cliente));
        }catch (DataIntegrityViolationException e) {
            throw new ClienteException("Ja existe um cliente com este email, telefone ou documento");
        }
    }

    public List<ClienteDTO> listarTodos(){
        return clienteRepository.findAll().stream()
                .map(clienteMapper::map)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) {
        ClienteModel cliente = clienteRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontrado("Cliente nao encontrado"));
        return clienteMapper.map(cliente);
    }

    public void update(Long id, ClienteDTO clienteNovo) {
        ClienteDTO clienteExistente = buscarPorId(id);
        System.out.println(clienteExistente);
        System.out.println(clienteNovo);

        // Verificar campos que devem ser atualizados
        if (!clienteNovo.getNome().isBlank()) clienteExistente.setNome(clienteNovo.getNome());
        if (!clienteNovo.getEmail().isBlank()) clienteExistente.setEmail(clienteNovo.getEmail());
        if (!clienteNovo.getTelefone().isBlank()) clienteExistente.setTelefone(clienteNovo.getTelefone());
        if (!clienteNovo.getDocumento().isBlank()) clienteExistente.setDocumento(clienteNovo.getDocumento());

        salvar(clienteExistente); // Ja possui Validations, por isso a reutilização.
    }

    public void excluir(Long id) {
        buscarPorId(id);
        clienteRepository.deleteById(id);
    }

}
