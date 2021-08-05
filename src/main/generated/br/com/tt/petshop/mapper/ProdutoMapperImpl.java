package br.com.tt.petshop.mapper;

import br.com.tt.petshop.dto.ProdutoConsulta;
import br.com.tt.petshop.model.Categoria;
import br.com.tt.petshop.model.Produto;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T21:20:19-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public ProdutoConsulta converteParaConsulta(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        String nomeCategoria = null;
        Long id = null;
        String descricao = null;
        BigDecimal valor = null;

        nomeCategoria = produtoCategoriaNome( produto );
        id = produto.getId();
        descricao = produto.getDescricao();
        valor = produto.getValor();

        ProdutoConsulta produtoConsulta = new ProdutoConsulta( id, descricao, valor, nomeCategoria );

        return produtoConsulta;
    }

    private String produtoCategoriaNome(Produto produto) {
        if ( produto == null ) {
            return null;
        }
        Categoria categoria = produto.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        String nome = categoria.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }
}
