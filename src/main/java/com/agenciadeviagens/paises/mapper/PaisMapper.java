package com.agenciadeviagens.paises.mapper;

import com.agenciadeviagens.paises.dto.PaisDTO;
import com.agenciadeviagens.paises.model.PaisModel;
import org.springframework.stereotype.Component;

@Component
public class PaisMapper {
    public PaisModel map(PaisDTO dto) {
        PaisModel pais = new PaisModel();
        pais.setId(dto.getId());
        pais.setNome(dto.getNome());
        pais.setContinente(dto.getContinente());
        return pais;
    }
    public PaisDTO map(PaisModel model) {
        PaisDTO pais = new PaisDTO();
        pais.setId(model.getId());
        pais.setNome(model.getNome());
        pais.setContinente(model.getContinente());
        return pais;
    }
}
