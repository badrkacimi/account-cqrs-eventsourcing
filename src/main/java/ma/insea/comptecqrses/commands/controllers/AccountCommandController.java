package ma.insea.comptecqrses.commands.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.insea.comptecqrses.commonapi.commands.CreateAccountCommand;
import ma.insea.comptecqrses.commonapi.commands.CreditAccountCommand;
import ma.insea.comptecqrses.commonapi.commands.WithdrawalAccountCommand;
import ma.insea.comptecqrses.dtos.CreateAccountRequestDTO;
import ma.insea.comptecqrses.dtos.CreditAccountRequestDTO;
import ma.insea.comptecqrses.dtos.WithdrawalAccountRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/commands/account")
@AllArgsConstructor
@Slf4j
public class AccountCommandController {

    private CommandGateway commandGateway;
    private EventStore eventStore;

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

    @PutMapping(path="/credit")
    public CompletableFuture<String> creditAccount(@RequestBody CreditAccountRequestDTO request){
        CompletableFuture<String> responseCommand = commandGateway.send( new CreditAccountCommand(
                request.getAccountId(),
                request.getAmount(),
                request.getCurrency()
        ));
        return responseCommand;
    }

    @PutMapping(path="/withdrawal")
    public CompletableFuture<String> withdrawalAccount(@RequestBody WithdrawalAccountRequestDTO request){
        CompletableFuture<String> responseCommand = commandGateway.send(new WithdrawalAccountCommand(
                request.getAccountId(),
                request.getAmount(),
                request.getCurrency()
        ));
        return responseCommand;
    }

    @GetMapping("/eventStore/{accountId}")
    public Stream getEventStore(@PathVariable String accountId) {
        return eventStore.readEvents(accountId).asStream();
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