package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.CategoriaConsulta;
import br.com.tt.petshop.dto.CategoriaCriacao;
import br.com.tt.petshop.dto.CategoriaListagem;
import br.com.tt.petshop.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
//@Api(tags = "Categorias", description = "Controller para gestão de Categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaListagem> lista(){
        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public CategoriaConsulta buscarPorId(@PathVariable Long id){
        return categoriaService.categoriaPorId(id);
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid CategoriaCriacao criacao){
        Long id = categoriaService.criar(criacao);
        return ResponseEntity.created(criarLocation(id)).build();
    }

    private URI criarLocation(Long id) {
        return URI.create(String.format("/categorias/%s", id));
    }

}
