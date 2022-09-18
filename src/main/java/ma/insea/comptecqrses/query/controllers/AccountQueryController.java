package ma.insea.comptecqrses.query.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.insea.comptecqrses.commonapi.queries.GetAccountByIdQuery;
import ma.insea.comptecqrses.commonapi.queries.GetAllAccountsQuery;
import ma.insea.comptecqrses.query.dtos.AccountDTO;
import ma.insea.comptecqrses.query.entities.Account;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/query/account")
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class AccountQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allAccounts")
    public List<AccountDTO> accountList(){
        List<AccountDTO> response = queryGateway.query(new GetAllAccountsQuery(),
                ResponseTypes.multipleInstancesOf(AccountDTO.class)).join();
        return response;
    }

    @GetMapping("/byId/{id}")
    public Response<AccountDTO> accountById(@PathVariable String id){
        AccountDTO response = queryGateway.query(new GetAccountByIdQuery(id),
                ResponseTypes.instanceOf(AccountDTO.class)).join();
        return new Response<>(true,201,response,null);
    }

}