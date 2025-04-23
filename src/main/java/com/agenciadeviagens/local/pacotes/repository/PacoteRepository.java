package com.agenciadeviagens.local.pacotes.repository;

import com.agenciadeviagens.local.pacotes.model.PacoteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacoteRepository extends JpaRepository<PacoteModel, Long> {
}
