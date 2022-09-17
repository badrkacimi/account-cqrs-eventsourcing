package ma.insea.comptecqrses.query.controllers;

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
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/query/account")
@AllArgsConstructor
@Slf4j
public class AccountCommandController {

    private QueryGateway queryGateway;
    private EventStore eventStore;

}