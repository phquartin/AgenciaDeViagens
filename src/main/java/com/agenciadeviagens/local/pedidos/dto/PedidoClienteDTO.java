package com.agenciadeviagens.local.pedidos.dto;

import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.local.servicos.dto.ServicosDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoClienteDTO {
    private Long id;
    private PacoteDTO pacote;
    private List<ServicosDTO> servicos;
}
