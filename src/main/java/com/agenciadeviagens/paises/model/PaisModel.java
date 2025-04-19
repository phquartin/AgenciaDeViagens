package com.agenciadeviagens.paises.model;

import com.agenciadeviagens.destinos.model.DestinoModel;
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
    private Continente continente;

    @OneToMany(mappedBy = "pais")
    @JsonIgnore
    private List<DestinoModel> destino;

}
