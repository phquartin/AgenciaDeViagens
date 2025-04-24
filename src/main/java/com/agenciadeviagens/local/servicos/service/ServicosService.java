package com.agenciadeviagens.local.servicos.service;

import com.agenciadeviagens.global.exceptions.RecursoNaoEncontrado;
import com.agenciadeviagens.global.interfaces.InterfaceService;
import com.agenciadeviagens.local.servicos.dto.ServicosDTO;
import com.agenciadeviagens.local.servicos.mapper.ServicosMapper;
import com.agenciadeviagens.local.servicos.repository.ServicosRepository;
import org.springframework.stereotype.Service;

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

    }

    @Override
    public void excluir(Long id) {

    }
}
