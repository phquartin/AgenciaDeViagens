package com.agenciadeviagens.pacotes.repository;

import com.agenciadeviagens.pacotes.model.PacoteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacoteRepository extends JpaRepository<PacoteModel, Long> {
}
