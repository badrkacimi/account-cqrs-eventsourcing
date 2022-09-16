package ma.insea.comptecqrses.commonapi.events;

import lombok.Getter;

public class AccountWithdrawnEvent extends BaseEvent<String> {
    @Getter double amount;
    @Getter String currency;

    public AccountWithdrawnEvent(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}

