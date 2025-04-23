package com.agenciadeviagens.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private String mensagem;
    private int statusCode;
    private LocalDateTime timestamp;
    private String path;
}
