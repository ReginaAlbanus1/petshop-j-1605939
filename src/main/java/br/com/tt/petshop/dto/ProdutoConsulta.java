package br.com.tt.petshop.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoConsulta {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private String nomeCategoria;
}
