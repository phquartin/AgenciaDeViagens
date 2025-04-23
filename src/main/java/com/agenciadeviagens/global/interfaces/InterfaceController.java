package com.agenciadeviagens.global.interfaces;

import org.springframework.web.servlet.ModelAndView;

public interface InterfaceController<T> {
    ModelAndView criar();
    ModelAndView listarTodos();
    ModelAndView visualizar(Long id);
    ModelAndView editar(Long id);
    String salvar(T entidade);
    String atualizar(T entidade);
    String deletar(Long id);
}
