package com.agenciadeviagens.local.destinos.repository;

import com.agenciadeviagens.local.destinos.model.DestinoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<DestinoModel, Long> {
}
