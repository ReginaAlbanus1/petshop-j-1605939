package br.com.tt.petshop.exception;

//@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)//422
public class CreditoException extends RuntimeException {

    public CreditoException(String mensagem) {
        super(mensagem);
    }
}
