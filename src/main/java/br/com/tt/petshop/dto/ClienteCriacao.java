package br.com.tt.petshop.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteCriacao {
    @NotBlank(message = "Informe o nome")
//    @Pattern(regexp = "[a-zA-Z]* [a-zA-Z]*", message = "Informe nome e sobrenome")
    private String nome;

    @NotBlank(message = "Informe o CPF")
    @CPF(message = "CPF está no formato incorreto")
    private String cpf;
}


