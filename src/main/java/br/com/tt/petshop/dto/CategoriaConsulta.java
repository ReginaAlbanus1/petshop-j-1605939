package br.com.tt.petshop.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoriaConsulta {
    private Long id;
    private String nome;
    private Integer quantidadeProdutos;
}
