package com.agenciadeviagens.global.util;

import com.agenciadeviagens.local.paises.validation.PaisException;

public class CapitalizePalavras {
    public static String capitalizeTodasPalavras(String texto) {
        String[] palavras = texto.toLowerCase().split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                resultado.append(palavra.substring(0, 1).toUpperCase())
                        .append(palavra.substring(1))
                        .append(" ");
            }
        }

        return resultado.toString().trim();
    }
}
