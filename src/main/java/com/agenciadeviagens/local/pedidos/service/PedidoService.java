package com.agenciadeviagens.local.pedidos.service;

import com.agenciadeviagens.global.exceptions.RecursoNaoEncontrado;
import com.agenciadeviagens.global.interfaces.InterfaceService;
import com.agenciadeviagens.local.clientes.dto.ClienteDTO;
import com.agenciadeviagens.local.clientes.mapper.ClienteMapper;
import com.agenciadeviagens.local.pedidos.dto.PedidoDTO;
import com.agenciadeviagens.local.pedidos.mapper.PedidoMapper;
import com.agenciadeviagens.local.pedidos.model.PedidoModel;
import com.agenciadeviagens.local.pedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService implements InterfaceService<PedidoDTO> {

    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    public PedidoService(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper ) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public void salvar(PedidoDTO entidade) {
        if (entidade.getCliente() == null || entidade.getPacote() == null) throw new IllegalArgumentException("Nao vai salvar pedido sem cliente ou pacote");
        pedidoRepository.save(pedidoMapper.map(entidade));
    }

    @Override
    public List<PedidoDTO> listarTodos() {
        return pedidoRepository.findAll().stream()
                .map(pedidoMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO buscarPorId(Long id) {
        PedidoModel pedidoExiste = pedidoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontrado("Pedido nao existe"));
        return pedidoMapper.map(pedidoExiste);
    }

    @Override
    public void update(Long id, PedidoDTO entidade) {
        // ENTIDADE IMUTÁVEL!
    }

    @Override
    public void excluir(Long id) {
        // TODO: FUTURAMENTE ADICIONAR UM BOOLEAN PARA DEFINIR SUA ATIVACAO. (EVITANDO O DELETE)
    }
}
