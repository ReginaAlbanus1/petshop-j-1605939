package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ProdutoConsulta;
import br.com.tt.petshop.repository.ProdutoRepository;
import br.com.tt.petshop.testutils.ProdutoTestFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @InjectMocks
    ProdutoService produtoService;

    @Mock
    ProdutoRepository produtoRepository;

    @Test
    void deveriaBuscarProdutosCategoriaHigiene(){
        //Preparação
        when(produtoRepository.findByCategoriaId(23L))
                .thenReturn(List.of(ProdutoTestFactory.criaCondicionador(),
                        ProdutoTestFactory.criaSabonete(), ProdutoTestFactory.criaShampoo()
                ));

        //Ação
        List<ProdutoConsulta> produtos = produtoService.produtosPorCategoria(23L);

        //Verificação
        assertThat(produtos)
            .usingFieldByFieldElementComparator()
            .containsExactly(
                new ProdutoConsulta(101L, "Condicionador PetLove", BigDecimal.TEN, "Higiene"),
                new ProdutoConsulta(102L, "Sabonete PetLove", BigDecimal.valueOf(5.50), "Higiene"),
                new ProdutoConsulta(103L, "Pack Shampoo PetLove 100", BigDecimal.valueOf(1500), "Higiene"));

        verify(produtoRepository).findByCategoriaId(23L);
    }

    @Test
    void deveriaListarTodosOsProdutos(){
        when(produtoRepository.findAll()).thenReturn(List.of(
                ProdutoTestFactory.criaCondicionador(),
                ProdutoTestFactory.criaSabonete(),
                ProdutoTestFactory.criaShampoo(),
                ProdutoTestFactory.criaShampooAntiPulgas()
        ));

        List<ProdutoConsulta> produtos = produtoService.listar();

        assertThat(produtos)
                .usingFieldByFieldElementComparator()
                .containsExactly(
                        new ProdutoConsulta(101L, "Condicionador PetLove", BigDecimal.TEN, "Higiene"),
                        new ProdutoConsulta(102L, "Sabonete PetLove", BigDecimal.valueOf(5.50), "Higiene"),
                        new ProdutoConsulta(103L, "Pack Shampoo PetLove 100", BigDecimal.valueOf(1500), "Higiene"),
                        new ProdutoConsulta(104L, "Shampoo PetLove Anti Pulgas", BigDecimal.valueOf(18), "Higiene")
                );

        verify(produtoRepository).findAll();//Garante que o findAll foi chamado UMA vez.
        verifyNoMoreInteractions(produtoRepository);
    }

    @Test
    void deveriaApagar(){
        when(produtoRepository.findById(101L)).thenReturn(Optional.of(ProdutoTestFactory.criaCondicionador()));

        produtoService.apagar(101L);

        verify(produtoRepository).findById(101L);
        verify(produtoRepository).deleteById(101L);
    }

}