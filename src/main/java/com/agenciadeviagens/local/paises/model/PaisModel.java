package com.agenciadeviagens.local.paises.model;

import com.agenciadeviagens.local.destinos.model.DestinoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_paises")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Continente continente;

    @OneToMany(mappedBy = "pais")
    @JsonIgnore
    private List<DestinoModel> destino;

    // Para o DataLoader
    public PaisModel(String nome, Continente continente) {
        this.nome = nome;
        this.continente = continente;
    }

}
