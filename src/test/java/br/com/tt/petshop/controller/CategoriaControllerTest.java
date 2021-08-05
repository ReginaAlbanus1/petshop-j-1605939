package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.CategoriaConsulta;
import br.com.tt.petshop.dto.CategoriaListagem;
import br.com.tt.petshop.service.CategoriaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoriaController.class)
class CategoriaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CategoriaService categoriaService;

    @Test
    void deveListar() throws Exception {
        Mockito.when(categoriaService.listar()).thenReturn(List.of(
                new CategoriaListagem(1L, "Higiene"),
                new CategoriaListagem(2L, "Ração")
        ));

        mockMvc.perform(get("/categorias"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("size([*])", is(2)))
                .andExpect(jsonPath("[0].id", not(nullValue())))
                .andExpect(jsonPath("[0].nome", is("Higiene")))
                .andExpect(jsonPath("[1].id", is(2)))
                .andExpect(jsonPath("[1].nome", is("Ração")))
                .andReturn().getResponse().getContentAsString();

        verify(categoriaService).listar();
    }

    @Test
    void deveListarNenhumaCategoria() throws Exception {
        Mockito.when(categoriaService.listar()).thenReturn(List.of());

        mockMvc.perform(get("/categorias"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("size([*])", is(0)));
    }

    @Test
    void deveBuscarCategoriaHigiene() throws Exception {
        Mockito.when(categoriaService.categoriaPorId(1L)).thenReturn(
                new CategoriaConsulta(1L, "Higiene", 1));

        mockMvc.perform(get("/categorias/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Higiene")))
                .andExpect(jsonPath("$.quantidadeProdutos", is(1)));
    }

//    @Test//TODO
//    void deveFalharPorCategoriaInexistente() throws Exception {
//        mockMvc.perform(get("/categorias/{id}", 100))
//                .andExpect(status().isNotFound());
//    }

}