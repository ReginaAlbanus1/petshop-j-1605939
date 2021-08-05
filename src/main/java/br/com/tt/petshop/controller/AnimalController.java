package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.AnimalCriacao;
import br.com.tt.petshop.dto.AnimalListagem;
import br.com.tt.petshop.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/animais")
@AllArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid AnimalCriacao criacao){
        Long idAnimal = animalService.criar(criacao);
        String location = String.format("/animais/%s", idAnimal);
        return ResponseEntity.created(URI.create(location)).build();
    }

    @GetMapping
    public List<AnimalListagem> listar(){
        return animalService.listar();
    }
}
