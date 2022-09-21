package ma.insea.comptecqrses.commonapi.events;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

public class AccountWithdrawnEvent extends BaseEvent<String> {
    @Getter double amount;
    @Getter String currency;
    @Getter private LocalDateTime withdrawnAt;

    public AccountWithdrawnEvent(String id, double amount, String currency, LocalDateTime withdrawnAt) {
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.withdrawnAt = withdrawnAt;
    }
}

