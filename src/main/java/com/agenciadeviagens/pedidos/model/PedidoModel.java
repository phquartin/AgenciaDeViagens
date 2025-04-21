package com.agenciadeviagens.pedidos.model;

import com.agenciadeviagens.clientes.model.ClienteModel;
import com.agenciadeviagens.pacotes.model.PacoteModel;
import com.agenciadeviagens.servicos.model.ServicosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "id_pacote")
    private PacoteModel pacote;

    @ManyToMany
    @JoinTable(
            name = "tb_pedidos_servicos",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_servico")
    )
    private List<ServicosModel> servicos;

}
