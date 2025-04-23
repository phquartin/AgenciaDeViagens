package com.agenciadeviagens.clientes.validation;

import com.agenciadeviagens.clientes.dto.ClienteDTO;
import com.agenciadeviagens.clientes.model.ClientType;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

public class ClienteValidation {
    public static void validarCampos(ClienteDTO cliente) {
        if (!cliente.getNome().matches("^[A-Za-zÀ-ÿ\\s]{2,50}$")) {
            throw new ClienteException("Nome inválido. Use apenas letras e espaços.");
        }

        // Validação do e-mail
        if (!cliente.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            throw new ClienteException("Email inválido. Verifique o formato (ex: nome@email.com).");
        }

        if (!cliente.getTelefone().matches("^\\+\\d{1,3}\\s?\\(?\\d{1,4}\\)?[\\s-]?\\d{4,5}[\\s-]?\\d{4}$")) {
            throw new ClienteException("Telefone inválido. Exemplo válido: +55 (61) 91234-5678");
        }

        // Validação do documento com base no tipo
        if (cliente.getTipo() == ClientType.NACIONAL) {
            if (!cliente.getDocumento().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
                throw new ClienteException("CPF inválido. Use o formato 000.000.000-00.");
            }
        } else if (cliente.getTipo() == ClientType.ESTRANGEIRO) {
            if (!cliente.getDocumento().matches("[A-Z]{2}\\d{6}")) {
                throw new ClienteException("Passaporte inválido. Use o formato AB123456.");
            }
        }
    }

}
