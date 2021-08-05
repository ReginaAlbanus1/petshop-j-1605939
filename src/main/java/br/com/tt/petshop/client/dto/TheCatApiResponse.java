package br.com.tt.petshop.client.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TheCatApiResponse {

    // private Integer fileSizeBytes; comentei pois não uso
    private String url;
}
