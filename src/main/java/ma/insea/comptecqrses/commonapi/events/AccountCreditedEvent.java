package ma.insea.comptecqrses.commonapi.events;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

public class AccountCreditedEvent extends BaseEvent<String> {
    @Getter double amount;
    @Getter String currency;
    @Getter private LocalDateTime creditAt;

    public AccountCreditedEvent(String id, double amount, String currency, LocalDateTime creditAt) {
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.creditAt=creditAt;

    }
}
