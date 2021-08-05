package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteConsultaFactory {

    public static ClienteConsulta converterParaConsultaDto(Cliente cliente){

        List<String> apelidos = cliente.getAnimais()
                .stream().map(Animal::getApelido).collect(Collectors.toList());

        return new ClienteConsulta(cliente.getId(), cliente.getNome(), cliente.getCpf(), apelidos);
    }
}
