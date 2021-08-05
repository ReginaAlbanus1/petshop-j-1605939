package br.com.tt.petshop.client;

import br.com.tt.petshop.client.dto.TheCatApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "tchecatapi", url = "https://api.thecatapi.com")

public interface TheCatApiClient {

    @GetMapping("/v1/images/search")
    TheCatApiResponse getFoto();
}
