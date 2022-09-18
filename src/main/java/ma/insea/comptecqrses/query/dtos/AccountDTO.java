package ma.insea.comptecqrses.query.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.insea.comptecqrses.commonapi.enums.AccountStatus;
import ma.insea.comptecqrses.query.entities.Operation;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private double balance;

    private AccountStatus status;

    private String currency;

    private Collection<Operation> Operations;
}
