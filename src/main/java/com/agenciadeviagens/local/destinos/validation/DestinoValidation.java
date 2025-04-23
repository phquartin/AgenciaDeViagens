package com.agenciadeviagens.local.destinos.validation;

import com.agenciadeviagens.global.util.CapitalizePalavras;
import com.agenciadeviagens.local.paises.validation.PaisException;

public class DestinoValidation {
    public static String capitalizeTodasPalavras(String texto) {
        if (texto.isEmpty()) throw new DestinoException("Nome vazio");
        return CapitalizePalavras.capitalizeTodasPalavras(texto);
    }
}
