package com.agenciadeviagens.local.servicos.service;

import com.agenciadeviagens.global.exceptions.RecursoNaoEncontrado;
import com.agenciadeviagens.global.interfaces.InterfaceService;
import com.agenciadeviagens.local.servicos.dto.ServicosDTO;
import com.agenciadeviagens.local.servicos.mapper.ServicosMapper;
import com.agenciadeviagens.local.servicos.model.ServicosModel;
import com.agenciadeviagens.local.servicos.repository.ServicosRepository;
import com.agenciadeviagens.local.servicos.validation.ServicosValidation;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicosService implements InterfaceService<ServicosDTO> {

    private final ServicosRepository servicosRepository;
    private final ServicosMapper servicosMapper;
    public ServicosService(ServicosRepository servicosRepository, ServicosMapper servicosMapper) {
        this.servicosRepository = servicosRepository;
        this.servicosMapper = servicosMapper;
    }

    @Override
    public void salvar(ServicosDTO entidade) {
        ServicosValidation.validarCampos(entidade);
        ServicosModel model = servicosMapper.map(entidade);
        servicosRepository.save(model);
    }

    @Override
    public List<ServicosDTO> listarTodos() {
        return servicosRepository.findAll().stream()
                .map(servicosMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public ServicosDTO buscarPorId(Long id) {
        return servicosMapper.map(servicosRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontrado("Servico nao existe")));
    }

    @Override
    public void update(Long id, ServicosDTO entidade) {
        ServicosDTO servicoExistente = buscarPorId(id);

        if(!entidade.getNome().isBlank()) servicoExistente.setNome(entidade.getNome());
        if(entidade.getPreco() != 0) servicoExistente.setPreco(entidade.getPreco());

        salvar(servicoExistente);
    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        try {
            servicosRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Pedidos dependem desse Servico");
        }

    }
}
