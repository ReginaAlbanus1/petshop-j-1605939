package br.com.tt.petshop.handler;

import br.com.tt.petshop.exception.CreditoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j //@Sl4j (Lombok) OU: private static final Logger LOG = LoggerFactory.getLogger(ClienteController.class);
@RestControllerAdvice // com html, sem Rest, @ControllerAdvice
public class CreditoControllerAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) //422
    public ErrorInfo trataErrodasdasdasdas(CreditoException e){
        log.info("Erro no crédito", e);
        return new ErrorInfo("erro_credito", e.getMessage());
    }

//    @ExceptionHandler(CreditoException.class)
//    public ResponseEntity trataErro(CreditoException e){
//        ErrorInfo info = new ErrorInfo("erro_credito", e.getMessage());
//        return ResponseEntity.unprocessableEntity().body(info);
//    }
}
