package com.agenciadeviagens.local.paises.validation;

public class PaisValidation {

    public static String capitalizeTodasPalavras(String texto) {
        if (texto.isEmpty()) {
            throw new PaisException("Nome vazio");
        }
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
