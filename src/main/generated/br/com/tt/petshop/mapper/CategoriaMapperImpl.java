package br.com.tt.petshop.mapper;

import br.com.tt.petshop.dto.CategoriaConsulta;
import br.com.tt.petshop.dto.CategoriaCriacao;
import br.com.tt.petshop.dto.CategoriaListagem;
import br.com.tt.petshop.model.Categoria;
import br.com.tt.petshop.model.Produto;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T21:20:20-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaListagem converterListagem(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        Long id = null;
        String nome = null;

        id = categoria.getId();
        nome = categoria.getNome();

        CategoriaListagem categoriaListagem = new CategoriaListagem( id, nome );

        return categoriaListagem;
    }

    @Override
    public CategoriaConsulta converterConsulta(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        Long id = null;
        String nome = null;

        id = categoria.getId();
        nome = categoria.getNome();

        Integer quantidadeProdutos = categoria.getProdutos().size();

        CategoriaConsulta categoriaConsulta = new CategoriaConsulta( id, nome, quantidadeProdutos );

        return categoriaConsulta;
    }

    @Override
    public Categoria converterCriacao(CategoriaCriacao criacao) {
        if ( criacao == null ) {
            return null;
        }

        String nome = null;

        nome = criacao.getNome();

        Long id = null;
        List<Produto> produtos = null;

        Categoria categoria = new Categoria( id, nome, produtos );

        return categoria;
    }
}
