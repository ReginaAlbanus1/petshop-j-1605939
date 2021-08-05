package br.com.tt.petshop.mapper;

import br.com.tt.petshop.dto.CategoriaConsulta;
import br.com.tt.petshop.dto.CategoriaCriacao;
import br.com.tt.petshop.dto.CategoriaListagem;
import br.com.tt.petshop.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaListagem converterListagem(Categoria categoria);

    @Mapping(target = "quantidadeProdutos",
            expression = "java(categoria.getProdutos().size())")
    CategoriaConsulta converterConsulta(Categoria categoria);

    Categoria converterCriacao(CategoriaCriacao criacao);

    //Método no padrão: NoQueQueroConverter from(oQueQueroConverter);
}
