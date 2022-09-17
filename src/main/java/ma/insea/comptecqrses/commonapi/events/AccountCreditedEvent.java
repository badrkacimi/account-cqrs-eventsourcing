package ma.insea.comptecqrses.commonapi.events;

import lombok.Getter;

import java.util.Date;

public class AccountCreditedEvent extends BaseEvent<String> {
    @Getter double amount;
    @Getter String currency;
    @Getter private Date creditAt;

    public AccountCreditedEvent(String id, double amount, String currency, Date creditAt) {
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.creditAt=creditAt;

    }
}
