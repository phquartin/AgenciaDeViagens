package com.agenciadeviagens.destinos.dto;

import com.agenciadeviagens.paises.model.PaisModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinoDTO {
    private Long id;
    private String nome;
    private PaisModel pais;
}
