package com.agenciadeviagens.local.paises.service;

import com.agenciadeviagens.global.exceptions.RecursoNaoEncontrado;
import com.agenciadeviagens.global.interfaces.InterfaceService;
import com.agenciadeviagens.local.paises.dto.PaisDTO;
import com.agenciadeviagens.local.paises.mapper.PaisMapper;
import com.agenciadeviagens.local.paises.repository.PaisRepository;
import com.agenciadeviagens.local.paises.validation.PaisException;
import com.agenciadeviagens.local.paises.validation.PaisValidation;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisService implements InterfaceService<PaisDTO> {

    private final PaisRepository paisRepository;
    private final PaisMapper paisMapper;
    public PaisService(PaisRepository paisRepository, PaisMapper paisMapper) {
        this.paisRepository = paisRepository;
        this.paisMapper = paisMapper;
    }


    @Override
    public void salvar(PaisDTO paisDTO) {

        PaisValidation.validarCampos(paisDTO);

        String capitalized = PaisValidation.capitalizeTodasPalavras(paisDTO.getNome());
        paisDTO.setNome(capitalized);

        try {
            paisRepository.save(paisMapper.map(paisDTO));
        }catch (DataIntegrityViolationException e){
            throw new PaisException("Ja existe um Pais com esse nome");
        } catch (Exception e){
            throw new PaisException(e.getMessage());
        }
    }

    @Override
    public List<PaisDTO> listarTodos() {
        return paisRepository.findAll()
                .stream()
                .map(paisMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public PaisDTO buscarPorId(Long id) {
        return paisMapper.map(paisRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontrado("Pais nao encontrado")));
    }

    @Override
    public void update(Long id, PaisDTO paisNovo) {
        PaisDTO paisExistente = buscarPorId(id);

        if(!paisNovo.getNome().isBlank()) paisExistente.setNome(paisNovo.getNome());

        salvar(paisExistente);

    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        try {
            paisRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Destinos dependem desse Pais!");
        }
    }
}
