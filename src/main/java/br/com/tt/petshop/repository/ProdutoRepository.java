package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    //Buscar produtos pelo ID da Categoria.
    List<Produto> findByCategoriaId(Long categoriaId);

    // isso funciona :), mas teria que passar a Categoria toda...
    // List<Produto>  findProdutoByCategoria(Categoria categoria);

    //Buscar produtos no intervalo de preço (mínimo, máximo)
    List<Produto> findByValorBetween(BigDecimal min, BigDecimal max);
}
