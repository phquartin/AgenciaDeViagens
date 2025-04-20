package com.agenciadeviagens.servicos.repository;

import com.agenciadeviagens.servicos.model.ServicosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicosRepository extends JpaRepository<ServicosModel, Long> {
}
