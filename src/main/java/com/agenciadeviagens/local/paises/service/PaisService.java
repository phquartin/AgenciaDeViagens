package com.agenciadeviagens.local.paises.service;

import com.agenciadeviagens.global.interfaces.InterfaceService;
import com.agenciadeviagens.local.paises.dto.PaisDTO;
import com.agenciadeviagens.local.paises.mapper.PaisMapper;
import com.agenciadeviagens.local.paises.repository.PaisRepository;
import com.agenciadeviagens.local.paises.validation.PaisException;
import com.agenciadeviagens.local.paises.validation.PaisValidation;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

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

        String nome = paisDTO.getNome();
        String nomeCapitalized = PaisValidation.capitalizeTodasPalavras(nome);
        paisDTO.setNome(nome);

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
        return List.of();
    }

    @Override
    public PaisDTO buscarPorId(Long id) {
        return null;
    }

    @Override
    public void update(Long id, PaisDTO paisDTO) {

    }

    @Override
    public void excluir(Long id) {

    }
}
