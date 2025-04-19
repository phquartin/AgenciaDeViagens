package com.agenciadeviagens.paises.dto;

import com.agenciadeviagens.paises.model.Continente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaisDTO {
    private Long id;
    private String nome;
    private Continente continente;
}
