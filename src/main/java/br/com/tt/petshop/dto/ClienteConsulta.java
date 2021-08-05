package br.com.tt.petshop.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteConsulta {
    private Long id;
    private String nome;
    private String cpf;
    private List<String> animais;

    public ClienteConsulta(Long id, String nome, String cpf, List<String> animais) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.animais = animais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<String> getAnimais() {
        return animais;
    }
}
