package com.agenciadeviagens.local.clientes.model;

import com.agenciadeviagens.local.pedidos.model.PedidoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 21, unique = true)
    private String telefone;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ClientType tipo;

    @Column(unique = true, nullable = false)
    private String documento;

    @OneToMany(mappedBy = "cliente")
    private List<PedidoModel> pedidos;

}
