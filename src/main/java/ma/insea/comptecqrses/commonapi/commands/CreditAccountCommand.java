package ma.insea.comptecqrses.commonapi.commands;

import lombok.Getter;

public class CreditAccountCommand extends BaseCommand<String> {
    @Getter private double amount;
    @Getter private String currency;
    public CreditAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount=amount;
        this.currency=currency;

    }
}
