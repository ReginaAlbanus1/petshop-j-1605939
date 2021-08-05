package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest//Sobe o jpa, hibernate, entidades, repositories
class ClienteRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired//Injeta em vez de usar construtor nos testes
    ClienteRepository clienteRepository;

    @BeforeEach
    void configuraMassaDados(){
        //Preparação - Injetar uns clientes de teste (Joao, Pedro, Felipe, Ana, Gabriela, Julia)
        testEntityManager.persist(new Cliente(null, "João", "942.965.820-46", null));
        testEntityManager.persist(new Cliente(null, "Pedro", "209.562.500-50", null));
        testEntityManager.persist(new Cliente(null, "Felipe", "553.388.570-65", null));
        testEntityManager.persist(new Cliente(null, "Ana", "382.768.620-20", null));
        testEntityManager.persist(new Cliente(null, "Gabriela", "590.167.870-20", null));
        testEntityManager.persist(new Cliente(null, "Julia", "011.037.200-07", null));
    }

    @Test
    void deveBuscarPorCpfJoao(){

        //Execução - buscaPorCPF
        Cliente cliente = clienteRepository
                .findByCpf("942.965.820-46")
                .orElseThrow(() -> new RuntimeException("Não encontrou o João"));

        //Verificação - VerificarSeRetornouSóOjoao
        assertEquals("942.965.820-46", cliente.getCpf());
        assertEquals("João", cliente.getNome());
        assertNotNull(cliente.getId());
    }

    @Test
    void deveRetornarPorNomeAna(){
        List<Cliente> clientes = clienteRepository.findByCpfOrNomeOrderByNomeAsc(null, "Ana");
        assertEquals(1, clientes.size());

        Cliente clienteAna = clientes.get(0);
        assertEquals("Ana", clienteAna.getNome());
        assertEquals("382.768.620-20", clienteAna.getCpf());
        assertNotNull(clienteAna.getId());
    }

    @Test
    void deveRetornarPorCpfJuliaENomePedro(){

        List<Cliente> clientes = clienteRepository.findByCpfOrNomeOrderByNomeAsc("011.037.200-07", "Pedro");

        Cliente clienteEsperadoJulia = new Cliente(6L, "Julia", "011.037.200-07", null);
        Cliente clienteEsperadoPedro = new Cliente(2L, "Pedro", "209.562.500-50", null);

//        assertEquals(clienteEsperadoJulia, clientes.get(0));
//        assertEquals(clienteEsperadoPedro, clientes.get(1));

        Assertions
                .assertThat(clientes)
                .usingFieldByFieldElementComparator()
                .usingElementComparatorIgnoringFields("id")
                .containsExactly(clienteEsperadoJulia, clienteEsperadoPedro);
    }

}