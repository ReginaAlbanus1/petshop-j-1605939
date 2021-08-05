package br.com.tt.petshop.client.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
Essa classe representa esse JSON:
{
  "fileSizeBytes": 94905,
  "url": "https://random.dog/916446ed-7d0b-403a-a7a4-cc10c7969ea1.jpg"
}
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
//TODO @JsonIgnoreProperties(ignoreUnknown = true) //ignora as propriedades que não queremos
public class RandomDogResponse {

    // private Integer fileSizeBytes; comentei pois não uso
    private String url;
}
