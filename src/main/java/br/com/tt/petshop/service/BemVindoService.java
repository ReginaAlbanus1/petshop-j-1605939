package br.com.tt.petshop.service;

import br.com.tt.petshop.dao.BemVindoDao;
import org.springframework.stereotype.Service;

@Service
public class BemVindoService {

    private final BemVindoDao dao;

    public BemVindoService(BemVindoDao dao) {
        this.dao = dao;
    }

    public String getMensagem() {
        return dao.getMensagem();
    }
}