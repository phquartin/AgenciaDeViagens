package com.agenciadeviagens.global.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface InterfaceController<T> {
    ModelAndView criar();
    String salvar(T entidade);
    ModelAndView listarTodos();
    ModelAndView visualizar(Long id);
    ModelAndView editar(Long id);
    String atualizar(T entidade, HttpServletRequest request);
    String deletar(Long id);
}
