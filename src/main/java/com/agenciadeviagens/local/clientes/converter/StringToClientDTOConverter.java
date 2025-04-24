package com.agenciadeviagens.local.clientes.converter;

import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToClientDTOConverter implements Converter<String, ClienteDTO> {

    @Autowired
    private ClienteService clienteService;

    @Override
    public ClienteDTO convert(String source) {
        if (source.isEmpty()) {
            return null;
        }

        return clienteService.buscarPorId(Long.parseLong(source));
    }
}

