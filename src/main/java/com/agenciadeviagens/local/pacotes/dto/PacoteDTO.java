package com.agenciadeviagens.local.pacotes.dto;

import com.agenciadeviagens.local.destinos.dto.DestinoDTO;
import com.agenciadeviagens.local.pacotes.model.PacoteType;
import com.agenciadeviagens.local.pedidos.dto.PedidoPacoteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacoteDTO {
    private Long id;
    private String nome;
    private int dias;
    private double preco;
    private List<DestinoDTO> destinos;
    private PacoteType tipo;
    private String descricao;
    List<PedidoPacoteDTO> pedidos = new ArrayList<>();
}
