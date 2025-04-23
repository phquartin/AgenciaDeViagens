package com.agenciadeviagens.local.clientes.dto;

import com.agenciadeviagens.local.clientes.model.ClientType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private ClientType tipo;
    private String documento;
}
