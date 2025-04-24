package com.agenciadeviagens.local.servicos.validation;

import com.agenciadeviagens.local.servicos.dto.ServicosDTO;

public class ServicosValidation {
    public static void validarCampos(ServicosDTO entidade) {
        if (entidade.getNome() == null || entidade.getNome().isEmpty()) throw new ServicosException("Nome deve ser preenchido");
        if (entidade.getPreco() <= 0) throw new ServicosException("Preco deve ser maior que zero");
    }
}
