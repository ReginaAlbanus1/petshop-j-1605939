package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Interface que extende o CrudRepository<Entidade, Tipo do Id>
@Repository//Não é obrigatório usar quando se extende uma das interfaces
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

//    Listar todos os clientes.
// não precisa implementar, pois já tem o findAll()

//    Buscar clientes por CPF.
    Optional<Cliente> findByCpf(String cpf);

//    Buscar clientes por Nome ou CPF
    List<Cliente> findByCpfOrNomeOrderByNomeAsc(String cpf, String nome);

    @Modifying //Indica que não é um SELECT, ou seja, update,insert,delete
    @Transactional //Abre uma transação do SPRING!!!!!
    @Query("update Cliente c Set c.nome=:nome Where c.id = :id ")
    void updateNomeById(Long id, String nome);
}
