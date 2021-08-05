package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.TipoAnimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE)
public class AnimalCriacao {

    //TODO os demais colocar bean validations
    @NotBlank
    private String apelido;
    private LocalDate nascimento;
    private Long tutorId;
    private TipoAnimal tipo;
}
