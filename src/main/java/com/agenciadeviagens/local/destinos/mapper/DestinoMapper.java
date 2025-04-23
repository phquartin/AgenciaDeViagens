package com.agenciadeviagens.local.destinos.mapper;

import com.agenciadeviagens.local.destinos.dto.DestinoDTO;
import com.agenciadeviagens.local.destinos.model.DestinoModel;
import com.agenciadeviagens.local.paises.mapper.PaisMapper;
import org.springframework.stereotype.Component;

@Component
public class DestinoMapper {

    private final PaisMapper paisMapper;

    public DestinoMapper(PaisMapper paisMapper) {
        this.paisMapper = paisMapper;
    }

    public DestinoModel map(DestinoDTO destinoDTO) {
        DestinoModel destinoModel = new DestinoModel();
        destinoModel.setId(destinoDTO.getId());
        destinoModel.setNome(destinoDTO.getNome());
        destinoModel.setPais(paisMapper.map(destinoDTO.getPais()));
        return destinoModel;
    }
    public DestinoDTO map(DestinoModel destinoModel) {
        DestinoDTO destinoDTO = new DestinoDTO();
        destinoDTO.setId(destinoModel.getId());
        destinoDTO.setNome(destinoModel.getNome());
        destinoDTO.setPais(paisMapper.map(destinoModel.getPais()));
        return destinoDTO;
    }
}
