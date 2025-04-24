package com.agenciadeviagens.local.destinos.validation;

import com.agenciadeviagens.global.util.CapitalizePalavras;
import com.agenciadeviagens.local.destinos.dto.DestinoDTO;

public class DestinoValidation {

    private static final String regex = "^\\p{L}+(?:[\\s\\-'’]\\p{L}+)*$";

    public static String capitalizeTodasPalavras(String texto) {
        return CapitalizePalavras.capitalizeTodasPalavras(texto);
    }
    public static void validarCampos(DestinoDTO destinoDTO) {
        if (destinoDTO.getNome().isEmpty()) throw new DestinoException("Nome vazio");
        if (!destinoDTO.getNome().matches(regex)) throw new DestinoException("Nome deve conter apenas letras");
        if (destinoDTO.getPais() == null) throw new DestinoException("Destino sem um Pais");
    }
}
