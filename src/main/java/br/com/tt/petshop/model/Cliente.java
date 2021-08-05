package br.com.tt.petshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CLIENTE")
@EqualsAndHashCode(of = {"id", "nome", "cpf"})
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerado pelo próprio banco
    @Column(name = "id_cliente")
    private Long id;

    @Column//Sem o name indica que o nome é igual ao banco
    private String nome;

    @Column
    private String cpf;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.REMOVE)
    private List<Animal> animais;

    public void alterarNome(String nome) {
        this.nome = nome;
    }
}
