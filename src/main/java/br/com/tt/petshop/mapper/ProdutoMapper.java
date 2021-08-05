package br.com.tt.petshop.mapper;

import br.com.tt.petshop.dto.ProdutoConsulta;
import br.com.tt.petshop.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(target = "nomeCategoria", source = "categoria.nome")
    ProdutoConsulta converteParaConsulta(Produto produto);

//Usamos o new Produto em vez de usar o Mapper.
//    @Mapping(ignore = true, target = "id")
//    @Mapping(source = "cri.descricao", target = "descricao")
//    @Mapping(source = "cri.valor", target = "valor")
//    @Mapping(source = "cat", target = "categoria")
//    Produto criar(ProdutoCriacao cri, Categoria cat);
}
