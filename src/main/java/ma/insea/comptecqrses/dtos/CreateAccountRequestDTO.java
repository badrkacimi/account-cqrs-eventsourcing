package ma.insea.comptecqrses.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequestDTO {
    private double amount;
    private String currency;

}
