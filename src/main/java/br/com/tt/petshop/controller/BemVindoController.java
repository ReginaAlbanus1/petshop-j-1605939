package br.com.tt.petshop.controller;

import br.com.tt.petshop.service.BemVindoService;
import org.springframework.stereotype.Controller;

@Controller
public class BemVindoController {

    private final BemVindoService service;

    public BemVindoController(BemVindoService service) {
        this.service = service;
    }

    public String getMensagem(){
        return service.getMensagem();
    }
}
