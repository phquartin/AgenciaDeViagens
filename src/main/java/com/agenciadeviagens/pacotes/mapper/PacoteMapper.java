package com.agenciadeviagens.pacotes.mapper;

import com.agenciadeviagens.destinos.mapper.DestinoMapper;
import com.agenciadeviagens.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.pacotes.model.PacoteModel;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PacoteMapper {

    private final DestinoMapper destinoMapper;

    public PacoteMapper(DestinoMapper destinoMapper) {
        this.destinoMapper = destinoMapper;
    }

    public PacoteModel map(PacoteDTO pacoteDTO) {
        PacoteModel pacoteModel = new PacoteModel();
        pacoteModel.setId(pacoteDTO.getId());
        pacoteModel.setNome(pacoteDTO.getNome());
        pacoteModel.setPreco(pacoteDTO.getPreco());
        pacoteModel.setTipo(pacoteDTO.getTipo());
        pacoteModel.setDias(pacoteDTO.getDias());
        pacoteModel.setDestinos(pacoteDTO.getDestinos().stream()
                .map(destinoMapper::map)
                .collect(Collectors.toList()));
        pacoteModel.setDescricao(pacoteDTO.getDescricao());
        return pacoteModel;
    }
    public PacoteDTO map(PacoteModel pacoteModel) {
        PacoteDTO pacoteDTO = new PacoteDTO();
        pacoteDTO.setId(pacoteModel.getId());
        pacoteDTO.setNome(pacoteModel.getNome());
        pacoteDTO.setPreco(pacoteModel.getPreco());
        pacoteDTO.setTipo(pacoteModel.getTipo());
        pacoteDTO.setDias(pacoteModel.getDias());
        pacoteDTO.setDestinos(pacoteModel.getDestinos().stream()
                .map(destinoMapper::map)
                .collect(Collectors.toList()));
        pacoteDTO.setDescricao(pacoteModel.getDescricao());
        return pacoteDTO;
    }

}
