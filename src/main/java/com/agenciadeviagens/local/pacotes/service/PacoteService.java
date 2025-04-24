package com.agenciadeviagens.local.pacotes.service;

import com.agenciadeviagens.global.exceptions.RecursoNaoEncontrado;
import com.agenciadeviagens.global.interfaces.InterfaceService;
import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.local.pacotes.mapper.PacoteMapper;
import com.agenciadeviagens.local.pacotes.model.PacoteModel;
import com.agenciadeviagens.local.pacotes.repository.PacoteRepository;
import com.agenciadeviagens.local.pacotes.validation.PacoteException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteService implements InterfaceService<PacoteDTO> {

    private final PacoteRepository pacoteRepository;
    private final PacoteMapper pacoteMapper;
    public PacoteService(PacoteRepository pacoteRepository, PacoteMapper pacoteMapper) {
        this.pacoteRepository = pacoteRepository;
        this.pacoteMapper = pacoteMapper;
    }

    @Override
    public void salvar(PacoteDTO entidade) {
        pacoteRepository.save(pacoteMapper.map(entidade));
    }

    public List<PacoteDTO> listarTodos() {
        return pacoteRepository.findAll().stream()
                .map(pacoteMapper::map)
                .toList();
    }
    public PacoteDTO buscarPorId(Long id) {
        PacoteModel pacoteEncontrado = pacoteRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontrado("Pacote Nao Encontrado"));
        return pacoteMapper.map(pacoteEncontrado);
    }

    @Override
    public void update(Long id, PacoteDTO entidade) {

    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        pacoteRepository.deleteById(id);
    }
}
