package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.ClienteConsulta;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.exception.CreditoException;
import br.com.tt.petshop.mapper.ClienteMapper;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //Listar todos os clientes
    public List<ClienteListagem> listar(){//TODO trocar iterable
        return clienteRepository.findAll().stream()
                .map(ClienteMapper.INSTANCE::converterListagem)
                .collect(Collectors.toList());
    }

//    private ClienteListagem converterParaListagemDto(Cliente cliente) {
//        //return new ClienteListagem(cliente.getId(), cliente.getNome(), cliente.getCpf());
//    }

    //Buscar clientes por CPF
    public ClienteConsulta buscarPorCpf(String cpf){
        return clienteRepository
                .findByCpf(cpf)
                .map(ClienteMapper.INSTANCE::converterConsulta)
                .orElseThrow();//TODO trocar para exceção específica
    }

    //TODO - Regra: não permitir cadastro de mesmo CPF
    public Long criar(ClienteCriacao criacao){
        validaCpf(criacao.getCpf());

        Cliente cliente = ClienteMapper.INSTANCE.fromCriacao(criacao);

        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteSalvo.getId();
    }

    private void validaCpf(String cpf) {

        if(cpf.endsWith("4")){
            //Inválido
            throw new CreditoException(String.format("CPF com pendências: %s", cpf));
        }

    }

    //Update
    public void atualiza(Long id, String nome){
        //Update personalizado no Repository
        // clienteRepository.updateNomeById(id, nome);

        //OU com find + update
        Cliente cliente = clienteRepository.findById(id).orElseThrow();

        if(!cliente.getNome().equalsIgnoreCase(nome)){
            cliente.alterarNome(nome);
            clienteRepository.save(cliente);
        }
    }

    //Delete
    public void apagar(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente entidadePorId(Long tutorId) {
        return clienteRepository
                .findById(tutorId)
                .orElseThrow();
    }
}
