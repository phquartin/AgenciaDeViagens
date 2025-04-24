package com.agenciadeviagens.local.pacotes.service;

import com.agenciadeviagens.global.exceptions.RecursoNaoEncontrado;
import com.agenciadeviagens.global.interfaces.InterfaceService;
import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;
import com.agenciadeviagens.local.pacotes.mapper.PacoteMapper;
import com.agenciadeviagens.local.pacotes.model.PacoteModel;
import com.agenciadeviagens.local.pacotes.repository.PacoteRepository;
import com.agenciadeviagens.local.pacotes.validation.PacoteException;
import com.agenciadeviagens.local.pacotes.validation.PacoteValidation;
import org.springframework.dao.DataIntegrityViolationException;
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
        PacoteValidation.validarCampos(entidade);
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
        PacoteDTO pacoteExistente = buscarPorId(id);

        if(!entidade.getDescricao().isBlank()) pacoteExistente.setDescricao(entidade.getDescricao());
        if(entidade.getPreco() != 0) pacoteExistente.setPreco(entidade.getPreco());
        if (entidade.getDias() != 0) pacoteExistente.setDias(entidade.getDias());
        if (!entidade.getNome().isBlank()) pacoteExistente.setNome(entidade.getNome());

        salvar(pacoteExistente);
    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        try {
            pacoteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Pedidos dependem desse Pacote!");
        }
    }
}
