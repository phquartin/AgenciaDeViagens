package com.agenciadeviagens.destinos.model;

import com.agenciadeviagens.pacotes.model.PacoteModel;
import com.agenciadeviagens.paises.model.PaisModel;
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

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    private PaisModel pais;

    @ManyToMany (mappedBy = "destinos")
    @JsonIgnore
    private List<PacoteModel> pacotes;

}
