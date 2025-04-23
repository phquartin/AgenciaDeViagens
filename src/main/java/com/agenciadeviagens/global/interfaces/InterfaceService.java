package com.agenciadeviagens.global.interfaces;

import java.util.List;

public interface InterfaceService<T> {
    void salvar(T entidade);
    List<T> listarTodos();
    T buscarPorId(Long id);
    void update(Long id, T entidade);
    void excluir(Long id);
}

