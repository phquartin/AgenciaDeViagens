package com.agenciadeviagens.local.paises.validation;

import com.agenciadeviagens.global.util.CapitalizePalavras;

public class PaisValidation {

    public static String capitalizeTodasPalavras(String texto) {
        if (texto.isEmpty()) throw new PaisException("Nome vazio");
        return CapitalizePalavras.capitalizeTodasPalavras(texto);
    }
}
