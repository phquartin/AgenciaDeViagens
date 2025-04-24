package com.agenciadeviagens.local.destinos.converter;

import com.agenciadeviagens.local.destinos.dto.DestinoDTO;
import com.agenciadeviagens.local.destinos.service.DestinoService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDestinoConverter implements Converter<String, DestinoDTO> {

    private final DestinoService destinoService;

    public StringToDestinoConverter(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @Override
    public DestinoDTO convert(String source) {
        try {
            Long id = Long.parseLong(source);
            return destinoService.buscarPorId(id); // Busca o DestinoDTO pelo ID
        } catch (NumberFormatException e) {
            return null; // Retorna null se o ID não for válido
        }
    }
}
