package com.agenciadeviagens.paises.repository;

import com.agenciadeviagens.paises.model.PaisModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<PaisModel, Long> {
}
