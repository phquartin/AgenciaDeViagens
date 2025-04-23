package com.agenciadeviagens.local.paises.repository;

import com.agenciadeviagens.local.paises.model.PaisModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<PaisModel, Long> {
}
