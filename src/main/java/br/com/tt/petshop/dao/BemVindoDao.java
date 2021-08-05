package br.com.tt.petshop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BemVindoDao {

    public String getMensagem(){
        return "Bem vindo!";
    }

}
