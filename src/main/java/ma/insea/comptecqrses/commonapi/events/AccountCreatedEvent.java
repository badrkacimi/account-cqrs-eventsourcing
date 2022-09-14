package ma.insea.comptecqrses.commonapi.events;

import lombok.Getter;

public class AccountCreatedEvent extends BaseEvent<String> {
    @Getter private double initialBalance;
    @Getter private String currency;

    public AccountCreatedEvent(String id, double initialBalance, String currency) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
    }

}
