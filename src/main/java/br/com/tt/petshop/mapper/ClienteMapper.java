package br.com.tt.petshop.mapper;

import br.com.tt.petshop.dto.ClienteConsulta;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper( ClienteMapper.class );

    ClienteListagem converterListagem(Cliente cliente);

    ClienteCriacao converterCriacao(Cliente cliente);

    @Mapping(ignore = true, target="id")
    Cliente fromCriacao(ClienteCriacao criacao);

    @Mapping(target = "animais", expression = "java(obterApelidosAnimais(cliente))")
    ClienteConsulta converterConsulta(Cliente cliente);

    //Método DEFAULT (INTERFACES -> java 8+)
    default List<String> obterApelidosAnimais(Cliente cliente){
        return cliente.getAnimais().stream()
                .map(Animal::getApelido)
                .collect(Collectors.toList());
    }

}
