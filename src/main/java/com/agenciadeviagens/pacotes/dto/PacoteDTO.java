package com.agenciadeviagens.pacotes.dto;

import com.agenciadeviagens.destinos.model.DestinoModel;
import com.agenciadeviagens.pacotes.model.PacoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacoteDTO {
    private Long id;
    private String nome;
    private int dias;
    private double preco;
    private List<DestinoModel> destinos;
    private PacoteType tipo;
    private String descricao;
}
