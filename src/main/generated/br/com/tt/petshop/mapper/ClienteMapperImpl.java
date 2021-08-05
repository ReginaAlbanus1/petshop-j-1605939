package br.com.tt.petshop.mapper;

import br.com.tt.petshop.dto.ClienteConsulta;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-03T21:20:20-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteListagem converterListagem(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String cpf = null;

        id = cliente.getId();
        nome = cliente.getNome();
        cpf = cliente.getCpf();

        ClienteListagem clienteListagem = new ClienteListagem( id, nome, cpf );

        return clienteListagem;
    }

    @Override
    public ClienteCriacao converterCriacao(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        String nome = null;
        String cpf = null;

        nome = cliente.getNome();
        cpf = cliente.getCpf();

        ClienteCriacao clienteCriacao = new ClienteCriacao( nome, cpf );

        return clienteCriacao;
    }

    @Override
    public Cliente fromCriacao(ClienteCriacao criacao) {
        if ( criacao == null ) {
            return null;
        }

        String nome = null;
        String cpf = null;

        nome = criacao.getNome();
        cpf = criacao.getCpf();

        Long id = null;
        List<Animal> animais = null;

        Cliente cliente = new Cliente( id, nome, cpf, animais );

        return cliente;
    }

    @Override
    public ClienteConsulta converterConsulta(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        String cpf = null;

        id = cliente.getId();
        nome = cliente.getNome();
        cpf = cliente.getCpf();

        List<String> animais = obterApelidosAnimais(cliente);

        ClienteConsulta clienteConsulta = new ClienteConsulta( id, nome, cpf, animais );

        return clienteConsulta;
    }
}
