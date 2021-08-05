package br.com.tt.petshop.testutils;

import br.com.tt.petshop.model.Categoria;
import br.com.tt.petshop.model.Produto;

import java.math.BigDecimal;

public class ProdutoTestFactory {

    public static Produto criaSabonete() {
        return new Produto(102L, "Sabonete PetLove", BigDecimal.valueOf(5.50), criaCategoriaHigiene());
    }

    public static Produto criaCondicionador() {
        return new Produto(101L, "Condicionador PetLove", BigDecimal.TEN, criaCategoriaHigiene());
    }

    public static Produto criaShampoo() {
        return new Produto(103L, "Pack Shampoo PetLove 100", BigDecimal.valueOf(1500), criaCategoriaHigiene());
    }

    public static Produto criaShampooAntiPulgas() {
        return new Produto(104L, "Shampoo PetLove Anti Pulgas", BigDecimal.valueOf(18), criaCategoriaHigiene());
    }

    private static Categoria criaCategoriaHigiene() {
        return new Categoria(1L, "Higiene", null);
    }
}