package ma.insea.comptecqrses.commonapi.events;

import lombok.Getter;
import ma.insea.comptecqrses.commonapi.enums.AccountStatus;

import java.util.Date;

public class AccountCreatedEvent extends BaseEvent<String> {
    @Getter private double initialBalance;
    @Getter private String currency;
    @Getter private AccountStatus status;
    @Getter private Date createAt;

    public AccountCreatedEvent(String id, double initialBalance,
                               String currency, AccountStatus status,Date createAt) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
        this.status = status;
        this.createAt = createAt;
    }
}
