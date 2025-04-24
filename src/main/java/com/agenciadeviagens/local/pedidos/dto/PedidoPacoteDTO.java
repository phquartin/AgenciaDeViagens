package com.agenciadeviagens.local.pedidos.dto;

import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.servicos.dto.ServicosDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoPacoteDTO {
    private Long id;
    private ClienteDTO cliente;
    private List<ServicosDTO> servicos;
}