package com.agenciadeviagens.clientes;

import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.clientes.mapper.ClienteMapper;
import com.agenciadeviagens.local.clientes.model.ClientType;
import com.agenciadeviagens.local.clientes.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper = new ClienteMapper();


    @Test
    public void criarCliente() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome("Pedro");
        clienteDTO.setEmail("pedro@gmail.com");
        clienteDTO.setTelefone("12345678");
        clienteDTO.setTipo(ClientType.NACIONAL);
        clienteDTO.setDocumento("000.000.000-21");

        var clienteSalvo = clienteRepository.save(clienteMapper.map(clienteDTO));

        assert clienteSalvo.getId() != null;
        assert clienteSalvo.getNome().equals("Pedro");
    }
}
