package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Categoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CategoriaRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    CategoriaRepository categoriaRepository;

    @BeforeEach
    void criaMassaDados() {
        testEntityManager.persist(new Categoria(null, "Ração Pequeno Porte", null));
        testEntityManager.persist(new Categoria(null, "Ração Filhotes", null));
        testEntityManager.persist(new Categoria(null, "Anti Pulgas", null));
        testEntityManager.persist(new Categoria(null, "Roupa", null));
        testEntityManager.persist(new Categoria(null, "Vacina", null));
    }

    @Test
    void deveRetornarCategoriasComecandoComRa() {

        List<Categoria> categorias = categoriaRepository.findByNomeStartingWith("Ra");

        //AssertThat com Extracting
        assertThat(categorias)
                .extracting(Categoria::getNome)
                .containsExactly("Ração Pequeno Porte", "Ração Filhotes");

        //Equals clássico
//        Assertions.assertEquals(2, categorias.size());
//        Assertions.assertEquals("Ração Pequeno Porte", categorias.get(0).getNome());
//        Assertions.assertEquals("Ração Filhotes", categorias.get(1).getNome());

        //AssertThat com classes
//        Categoria categoriaRacaoPP = new Categoria(null, "Ração Pequeno Porte");
//        Categoria categoriaRacaoFilhotes = new Categoria(null, "Ração Filhotes");
//        assertThat(categorias)
//                .usingFieldByFieldElementComparator()
//                .usingElementComparatorIgnoringFields("id")
//                .containsExactly(categoriaRacaoPP, categoriaRacaoFilhotes);

    }

    @Test
    void deveRetornarListaVazia() {
        List<Categoria> categorias = categoriaRepository.findByNomeStartingWith("Sham");
        Assertions.assertEquals(0, categorias.size());
    }
}