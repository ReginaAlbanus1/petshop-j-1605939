package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    //Query methods:

    long countByApelido(String apelido);
    boolean existsByApelido(String apelido);

    List<Animal> findByNascimentoBetweenAndApelidoEquals(LocalDate inicio,
                                                         LocalDate fim,
                                                         String apelido);

    //JPQL

    @Query("select a from Animal a join a.tutor t " +
            "Where a.nascimento between :inicio and :fim or apelido = :apelido " +
            "and t.nome = :nomeCliente ")
    List<Animal> buscarAnimais(LocalDate inicio, LocalDate fim, String apelido, String nomeCliente);

    //SQL

    @Query(nativeQuery = true,
            value = "select a.* from TB_ANIMAL a inner join TB_CLIENTE c " +
                    "where " +
                    "c.id = a.cliente_id " +
                    "dt_nasc between ? and ? or txt_apelido = ? " +
                    "and c.nome = ?")
    List<Animal> buscarAnimaisSql(LocalDate inicio, LocalDate fim, String apelido, String nomeCliente);

}