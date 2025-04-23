package com.agenciadeviagens.local.servicos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicosDTO {
    private Long id;
    private String nome;
    private double preco;
}
