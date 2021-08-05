package br.com.tt.petshop.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorInfo {
    private String codigo;
    private String mensagem;
}
