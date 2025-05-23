package com.agenciadeviagens.local.pedidos.repository;

import com.agenciadeviagens.local.clientes.model.ClienteModel;
import com.agenciadeviagens.local.pedidos.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
