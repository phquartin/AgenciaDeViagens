package com.agenciadeviagens.local.paises.validation;

import com.agenciadeviagens.global.util.CapitalizePalavras;
import com.agenciadeviagens.local.paises.dto.PaisDTO;

public class PaisValidation {

    private static final String regex = "^\\p{L}+(?:[\\s\\-'’]\\p{L}+)*$";

    public static String capitalizeTodasPalavras(String nome) {
        return CapitalizePalavras.capitalizeTodasPalavras(nome);
    }
    public static void validarCampos(PaisDTO pais) {
        if (pais.getNome().isEmpty()) throw new PaisException("Nome vazio");
        if (!pais.getNome().matches(regex)) throw new PaisException("Nome deve conter apenas letras");
    }
}
