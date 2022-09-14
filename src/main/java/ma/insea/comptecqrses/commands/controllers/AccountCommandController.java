package ma.insea.comptecqrses.commands.controllers;

import lombok.AllArgsConstructor;
import ma.insea.comptecqrses.commonapi.commands.CreateAccountCommand;
import ma.insea.comptecqrses.dtos.CreateAccountRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/commands/account")
@AllArgsConstructor
public class AccountCommandController {

    private CommandGateway commandGateway;
    @PostMapping(path="/create")
    @ResponseStatus(HttpStatus.CREATED)

    public CompletableFuture<String> createAccount(@RequestBody CreateAccountRequestDTO request){
        CompletableFuture<String> responseCommand = commandGateway.send( new CreateAccountCommand(
                UUID.randomUUID().toString().replace("-","").substring(8,17),
                request.getAmount(),
                request.getCurrency()
        ));
     return responseCommand;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        ResponseEntity<String> entity = new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return entity;
    }
}