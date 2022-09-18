package ma.insea.comptecqrses.commands.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalAccountRequestDTO {
    private String accountId;
    private double amount;
    private String currency;

}
