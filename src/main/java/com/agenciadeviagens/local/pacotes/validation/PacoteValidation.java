package com.agenciadeviagens.local.pacotes.validation;

import com.agenciadeviagens.local.pacotes.dto.PacoteDTO;

public class PacoteValidation {
    public static void validarCampos(PacoteDTO pacote) {
        if (pacote.getNome() == null || pacote.getNome().isEmpty()) throw new PacoteException("Nome deve ser preenchido");
        if (pacote.getDias() <= 0) throw new PacoteException("Dias deve ser maior que 0");
        if (pacote.getPreco() <= 0) throw new PacoteException("Preco deve ser maior que 0");
        if (pacote.getDestinos() == null) throw new PacoteException("Destinos devem ser preenchidos");
    }
}
