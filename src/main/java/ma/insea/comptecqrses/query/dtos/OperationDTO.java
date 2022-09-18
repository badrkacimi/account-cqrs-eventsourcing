package ma.insea.comptecqrses.query.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.insea.comptecqrses.commonapi.enums.OperationTypes;
import ma.insea.comptecqrses.query.entities.Account;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDTO {

    private double amount;

    private Date operationDate;

    private OperationTypes operationType;

    private Account account;
}
