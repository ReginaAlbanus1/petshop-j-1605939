package br.com.tt.petshop.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String apelido;

    @Column
    private LocalDate nascimento;

    //FK - chave estrangeira - Foreign Key
    @JoinColumn(name = "cliente_id")
    @ManyToOne
    private Cliente tutor;

    @Column
    private String foto;
}
