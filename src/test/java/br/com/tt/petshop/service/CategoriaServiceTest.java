package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.CategoriaConsulta;
import br.com.tt.petshop.model.Categoria;
import br.com.tt.petshop.model.Produto;
import br.com.tt.petshop.repository.CategoriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {

    @Mock
    CategoriaRepository categoriaRepository;

    @InjectMocks
    CategoriaService categoriaService;

    @Test
    @DisplayName("Consulta Vacina Por ID")
    void deveriaConsultarCategoriaVacinas(){
        List<Produto> produtos = List.of(
                new Produto(1L, "Vac1", null, null),
                new Produto(1L, "Vac3", null, null),
                new Produto(2L, "Vac2", null, null));
        Categoria categoriaRetornadoDoRepository = new Categoria(101L, "Vacina", produtos);
        Mockito.when(categoriaRepository.findById(101L)).thenReturn(Optional.of(categoriaRetornadoDoRepository));

        CategoriaConsulta dto = categoriaService.categoriaPorId(101L);

        Assertions.assertEquals(101L, dto.getId());
        Assertions.assertEquals("Vacina", dto.getNome());
        Assertions.assertEquals(3, dto.getQuantidadeProdutos(), "Deveria ter 2 produtos na lista");
    }
}