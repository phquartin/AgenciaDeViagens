package com.agenciadeviagens.local.pacotes.service;

import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.local.pacotes.mapper.PacoteMapper;
import com.agenciadeviagens.local.pacotes.model.PacoteModel;
import com.agenciadeviagens.local.pacotes.repository.PacoteRepository;
import com.agenciadeviagens.local.pacotes.validation.PacoteException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteService {

    private final PacoteRepository pacoteRepository;
    private final PacoteMapper pacoteMapper;
    public PacoteService(PacoteRepository pacoteRepository, PacoteMapper pacoteMapper) {
        this.pacoteRepository = pacoteRepository;
        this.pacoteMapper = pacoteMapper;
    }

    public List<PacoteDTO> buscarPacotes() {
        return pacoteRepository.findAll().stream()
                .map(pacoteMapper::map)
                .toList();
    }
    public PacoteDTO buscarPacotePorId(Long id) {
        PacoteModel pacoteEncontrado = pacoteRepository.findById(id).orElseThrow(() -> new PacoteException("Pacote Nao Encontrado"));
        return pacoteMapper.map(pacoteEncontrado);
    }

}
