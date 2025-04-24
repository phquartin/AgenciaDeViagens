package com.agenciadeviagens.local.pacotes.converter;

import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.local.pacotes.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToPacoteDTOConverter implements Converter<String, PacoteDTO> {

    @Autowired
    private PacoteService pacoteService;

    @Override
    public PacoteDTO convert(String source) {
        if (source.isEmpty()) {
            return null;
        }

        return pacoteService.buscarPorId(Long.parseLong(source));
    }
}

