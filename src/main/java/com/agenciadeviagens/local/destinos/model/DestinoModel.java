package com.agenciadeviagens.local.destinos.model;

import com.agenciadeviagens.local.pacotes.model.PacoteModel;
import com.agenciadeviagens.local.paises.model.PaisModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_destinos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToOne
    private PaisModel pais;

    @ManyToMany (mappedBy = "destinos")
    @JsonIgnore
    private List<PacoteModel> pacotes;

}
