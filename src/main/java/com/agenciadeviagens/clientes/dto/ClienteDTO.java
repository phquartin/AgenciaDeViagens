package com.agenciadeviagens.clientes.dto;

import com.agenciadeviagens.clientes.model.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private ClientType tipo;
    private String documento;
}
