package br.com.tt.petshop.controller;

import br.com.tt.petshop.dto.ClienteConsulta;
import br.com.tt.petshop.dto.ClienteCriacao;
import br.com.tt.petshop.dto.ClienteListagem;
import br.com.tt.petshop.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
//@Api(tags = "Clientes", description = "Controller para gestão de Clientes")
public class ClienteController {

    private final ClienteService clienteService;

    //LISTA - GET - 200(ok) - /clientes

    //    @ApiOperation("Obtém a lista de Clientes")
    @GetMapping // == @RequestMapping(method = RequestMethod.GET)
    public List<ClienteListagem> lista() {
        return clienteService.listar();
    }

    //UNITÁRIO - GET - 200 (ok) - /clientes/{cpf/ID}
    @GetMapping("/{cpf}")
    public ClienteConsulta obterPorCpf(@PathVariable("cpf") String cpf) {
        return clienteService.buscarPorCpf(cpf);
    }

    //APAGAR - DELETE - 204 (no content) - /clientes/{cpf/ID}
    @DeleteMapping("/{id}")
    public void apagar(@PathVariable("id") Long id) {
        clienteService.apagar(id);//TODO usar CPF ou definir o ID como padrão
        //return ResponseEntity.noContent().build();
    }

    //ATUALIZAÇÃO parcial -  PATCH - 204(no content) - /clientes/{cpf/ID}

    @PatchMapping("/{id}")
    //TODO: arrumar Nome
    public void atualiza(@PathVariable Long id, @RequestBody String nome) {
        clienteService.atualiza(id, nome);
    }

    //CRIAÇÃO - POST - 201(created) - /clientes
    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid ClienteCriacao criacao) {
        Long id = clienteService.criar(criacao);
        URI location = URI.create(String.format("/clientes/%s", id));
        return ResponseEntity.created(location).build();
    }


    //ATUALIZAÇÃO completo - PUT - 204(no content) - /clientes/{cpf/ID}
    //não temos atualização completa no cliente

/**
 * {@link br.com.tt.petshop.handler.CreditoControllerAdvice}

 @ExceptionHandler(CreditoException.class)
 @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) public ErrorInfo trataErro(CreditoException e){
 log.info("Erro no crédito", e);
 return new ErrorInfo("erro_credito", e.getMessage());
 }
 */

}
