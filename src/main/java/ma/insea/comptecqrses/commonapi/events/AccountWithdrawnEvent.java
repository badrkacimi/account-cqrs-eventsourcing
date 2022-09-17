package ma.insea.comptecqrses.commonapi.events;

import lombok.Getter;

import java.util.Date;

public class AccountWithdrawnEvent extends BaseEvent<String> {
    @Getter double amount;
    @Getter String currency;
    @Getter private Date withdrawnAt;

    public AccountWithdrawnEvent(String id, double amount, String currency, Date withdrawnAt) {
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.withdrawnAt = withdrawnAt;
    }
}

