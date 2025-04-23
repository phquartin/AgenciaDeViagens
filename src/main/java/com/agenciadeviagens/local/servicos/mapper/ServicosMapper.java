package com.agenciadeviagens.local.servicos.mapper;

import com.agenciadeviagens.local.servicos.dto.ServicosDTO;
import com.agenciadeviagens.local.servicos.model.ServicosModel;
import org.springframework.stereotype.Component;

@Component
public class ServicosMapper {
    public ServicosModel map(ServicosDTO servicosDTO) {
        ServicosModel servicosModel = new ServicosModel();
        servicosModel.setId(servicosDTO.getId());
        servicosModel.setNome(servicosDTO.getNome());
        servicosModel.setPreco(servicosDTO.getPreco());
        return servicosModel;
    }
    public ServicosDTO map(ServicosModel servicosModel) {
        ServicosDTO servicosDTO = new ServicosDTO();
        servicosDTO.setId(servicosModel.getId());
        servicosDTO.setNome(servicosModel.getNome());
        servicosDTO.setPreco(servicosModel.getPreco());
        return servicosDTO;
    }
}
