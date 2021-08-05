package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ClienteConsulta;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    ClienteRepository clienteRepository;

    @InjectMocks
    ClienteService clienteService;

    @Test
    void deveListarClientesListaVazia() {
        when(clienteRepository.findAll()).thenReturn(List.of());

        //Ação!
        List<ClienteListagem> clientes = clienteService.listar();
        //Verificação
        assertEquals(0, clientes.size());
    }

    @Test
    void deveListarDoisClientes() {
        Cliente joao = new Cliente(1L, "João", "942.965.820-46", null);
        Cliente pedro = new Cliente(2L, "Pedro", "209.562.500-50", null);
        when(clienteRepository.findAll()).thenReturn(List.of(joao, pedro));

        List<ClienteListagem> clientes = clienteService.listar();
        assertThat(clientes)
                .extracting("id", "nome", "cpf")
                .containsExactly(
                        tuple(1L, "João", "942.965.820-46"),
                        tuple(2L, "Pedro", "209.562.500-50")
                );

        /*
        ClienteListagem joaoDto = new ClienteListagem(1L, "João", "asdasdas");
        ClienteListagem pedroDto = new ClienteListagem(2L, "Pedro", "209.562.500-50");

        assertThat(clientes)
                .usingFieldByFieldElementComparator()
                .containsExactly(joaoDto, pedroDto);
        */
    }

    @Test
    void deveBuscarClientePorCpf(){
        Animal rex = new Animal(101L, "Rex", LocalDate.parse("2021-01-02"), null, null);
        Cliente joao = new Cliente(1L, "João", "942.965.820-46", List.of(rex));
        when(clienteRepository.findByCpf("942.965.820-46")).thenReturn(Optional.of(joao));

        ClienteConsulta cliente = clienteService.buscarPorCpf("942.965.820-46");

        ClienteConsulta clienteEsperado = new ClienteConsulta(1L, "João", "942.965.820-46", List.of("Rex"));
        assertThat(cliente)
                .usingRecursiveComparison()
                .isEqualTo(clienteEsperado);

    }

//deveCriarCliente
//deveAtualizarNomeCliente
//deveApagarCliente
//
//naoDeveAtualizarSeMesmoNome
//deveFalharAoBuscarPorCpfInexistente
//deveFalharSeNaoEncontrarCliente


}