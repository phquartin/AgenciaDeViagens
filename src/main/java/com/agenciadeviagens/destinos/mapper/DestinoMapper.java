package com.agenciadeviagens.destinos.mapper;

import com.agenciadeviagens.destinos.dto.DestinoDTO;
import com.agenciadeviagens.destinos.model.DestinoModel;
import org.springframework.stereotype.Component;

@Component
public class DestinoMapper {
    public DestinoModel map(DestinoDTO destinoDTO) {
        DestinoModel destinoModel = new DestinoModel();
        destinoModel.setId(destinoDTO.getId());
        destinoModel.setNome(destinoDTO.getNome());
        destinoModel.setPais(destinoDTO.getPais());
        return destinoModel;
    }
    public DestinoDTO map(DestinoModel destinoModel) {
        DestinoDTO destinoDTO = new DestinoDTO();
        destinoDTO.setId(destinoModel.getId());
        destinoDTO.setNome(destinoModel.getNome());
        destinoDTO.setPais(destinoModel.getPais());
        return destinoDTO;
    }
}
