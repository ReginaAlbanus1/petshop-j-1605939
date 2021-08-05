package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ProdutoConsulta;
import br.com.tt.petshop.dto.ProdutoCriacao;
import br.com.tt.petshop.mapper.ProdutoMapper;
import br.com.tt.petshop.model.Categoria;
import br.com.tt.petshop.model.Produto;
import br.com.tt.petshop.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaService categoriaService;

    public List<ProdutoConsulta> produtosPorCategoria(Long categoriaId){
        return produtoRepository
                .findByCategoriaId(categoriaId).stream()
                .map(ProdutoMapper.INSTANCE::converteParaConsulta)
                .collect(Collectors.toList());
    }

    public List<ProdutoConsulta> listar() {
        return produtoRepository.findAll().stream()
                .map(ProdutoMapper.INSTANCE::converteParaConsulta)
                .collect(Collectors.toList());
    }

    public void apagar(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow();

        if(produto != null){
            produtoRepository.deleteById(produto.getId());
        }
    }

    public void criar(ProdutoCriacao criacao){
        //Pra criar um produto, precisaremos da entidade Categoria.
        Categoria categoria = categoriaService.entidadePorId(criacao.getCategoriaId());

        // Preferi não usar o mapper e demos um new no Produto()
        // Produto produto1 = ProdutoMapper.INSTANCE.criar(criacao, categoria);

        Produto produto = new Produto(null,
                criacao.getDescricao(),
                criacao.getValor(),
                categoria);//Precisa da entidade "completa" pra poder criar um produto.

        produtoRepository.save(produto);
    }

}
