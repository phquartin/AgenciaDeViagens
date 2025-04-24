package com.agenciadeviagens.local.servicos.converter;

import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.local.pacotes.service.PacoteService;
import com.agenciadeviagens.local.servicos.dto.ServicosDTO;
import com.agenciadeviagens.local.servicos.service.ServicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToServicoDTOConverter implements Converter<String, ServicosDTO> {

    @Autowired
    private ServicosService servicosService;

    @Override
    public ServicosDTO convert(String source) {
        if (source.isEmpty()) {
            return null;
        }

        return servicosService.buscarPorId(Long.parseLong(source));
    }
}

