package com.agenciadeviagens.destinos.repository;

import com.agenciadeviagens.destinos.model.DestinoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<DestinoModel, Long> {
}
