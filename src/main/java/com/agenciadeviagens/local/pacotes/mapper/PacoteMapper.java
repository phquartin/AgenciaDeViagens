package com.agenciadeviagens.local.pacotes.mapper;

import com.agenciadeviagens.local.destinos.mapper.DestinoMapper;
import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.local.pacotes.model.PacoteModel;
import com.agenciadeviagens.local.pedidos.dto.PedidoDTO;
import com.agenciadeviagens.local.pedidos.dto.PedidoPacoteDTO;
import com.agenciadeviagens.local.pedidos.mapper.PedidoClienteMapper;
import com.agenciadeviagens.local.pedidos.mapper.PedidoPacoteMapper;
import com.agenciadeviagens.local.pedidos.model.PedidoModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PacoteMapper {

    private final DestinoMapper destinoMapper;
    private final PedidoPacoteMapper pedidoPacoteMapper;

    public PacoteMapper(DestinoMapper destinoMapper, PedidoPacoteMapper pedidoPacoteMapper) {
        this.destinoMapper = destinoMapper;
        this.pedidoPacoteMapper = pedidoPacoteMapper;
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

        List<PedidoModel> list = pacoteDTO.getPedidos().stream()
                .map(pedidoPacoteMapper::map)
                .toList();
        pacoteModel.setPedidos(list);

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

        List<PedidoPacoteDTO> collect = pacoteModel.getPedidos().stream()
                .map(pedidoPacoteMapper::map)
                .toList();
        pacoteDTO.setPedidos(collect);

        return pacoteDTO;
    }

}
