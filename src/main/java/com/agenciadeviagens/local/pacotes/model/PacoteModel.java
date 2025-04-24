package com.agenciadeviagens.local.pacotes.model;

import com.agenciadeviagens.local.destinos.model.DestinoModel;
import com.agenciadeviagens.local.pedidos.model.PedidoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_pacotes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @ManyToMany
    @JoinTable(
            name="destino_pacote",
            joinColumns = @JoinColumn(name = "id_pacote"),
            inverseJoinColumns = @JoinColumn(name = "id_destino")
    )
    private List<DestinoModel> destinos;

    @Column(nullable = false)
    private int dias;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PacoteType tipo;

    private String descricao;

    @OneToMany(mappedBy = "pacote")
    private List<PedidoModel> pedidos;

}
