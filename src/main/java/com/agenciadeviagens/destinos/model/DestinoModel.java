package com.agenciadeviagens.destinos.model;

import com.agenciadeviagens.paises.model.PaisModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_destinos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private PaisModel pais;

}
