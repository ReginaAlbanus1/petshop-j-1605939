package br.com.tt.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE)
public class AnimalListagem {

    private String apelido;
    private LocalDate nascimento;
    private String foto;
    private String tutor;
}
