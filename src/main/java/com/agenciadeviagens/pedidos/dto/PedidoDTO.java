package com.agenciadeviagens.pedidos.dto;

import com.agenciadeviagens.clientes.dto.ClienteDTO;
import com.agenciadeviagens.clientes.model.ClienteModel;
import com.agenciadeviagens.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.pacotes.model.PacoteModel;
import com.agenciadeviagens.servicos.dto.ServicosDTO;
import com.agenciadeviagens.servicos.model.ServicosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private ClienteDTO cliente;
    private PacoteDTO pacote;
    private List<ServicosDTO> servicos;
}
