package com.agenciadeviagens.local.destinos.dto;

import com.agenciadeviagens.local.paises.dto.PaisDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinoDTO {
    private Long id;
    private String nome;
    private PaisDTO pais;
}
