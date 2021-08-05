package br.com.tt.petshop.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoriaCriacao {

    @NotBlank(message = "Informar o nome da categoria")
    @Size(min = 3, max = 30, message = "O nome da categoria deve ter de 3 a 30 caracteres")
    private String nome;
}
