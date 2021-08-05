package br.com.tt.petshop.client;

import br.com.tt.petshop.client.dto.RandomDogResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// https://random.dog/woof.json

@FeignClient(name = "random-dog", url = "https://random.dog")
public interface RandomDogClient {

    @GetMapping("/woof.json")
    RandomDogResponse getFoto();
}

