package br.com.tt.petshop.service;

import br.com.tt.petshop.client.RandomDogClient;
import br.com.tt.petshop.client.TheCatApiClient;
import br.com.tt.petshop.client.dto.RandomDogResponse;
import br.com.tt.petshop.client.dto.TheCatApiResponse;
import br.com.tt.petshop.dto.AnimalCriacao;
import br.com.tt.petshop.dto.AnimalListagem;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.TipoAnimal;
import br.com.tt.petshop.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnimalService {

    private AnimalRepository animalRepository;
    private ClienteService clienteService;
    private RandomDogClient randomDogClient;
    private TheCatApiClient theCatApiClient;

    public Long criar(AnimalCriacao criacao) {
        TipoAnimal tipo = criacao.getTipo();
        String urlFoto;
        if (tipo == TipoAnimal.CAO) {

            RandomDogResponse foto = randomDogClient.getFoto();
            urlFoto = foto.getUrl();

        } else {
            TheCatApiResponse foto = theCatApiClient.getFoto();
            urlFoto = foto.getUrl();
        }
        Cliente tutor = clienteService.entidadePorId(criacao.getTutorId());
        Animal animal = new Animal(null, criacao.getApelido(), criacao.getNascimento(), tutor, urlFoto);
        Animal animalSalvo = animalRepository.save(animal);
        return animalSalvo.getId();


    }

    public List<AnimalListagem> listar() {
        return animalRepository.findAll().stream()
                .map(animal -> converterParaDto(animal))
                .collect(Collectors.toList());
    }

    private AnimalListagem converterParaDto(Animal animal) {
        return new AnimalListagem(animal.getApelido(),
                animal.getNascimento(), animal.getFoto(),
                animal.getTutor().getNome());
    }


}
