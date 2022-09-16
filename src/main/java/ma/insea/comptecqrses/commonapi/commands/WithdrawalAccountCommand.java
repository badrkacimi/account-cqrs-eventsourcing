package ma.insea.comptecqrses.commonapi.commands;

import lombok.Getter;

public class WithdrawalAccountCommand extends BaseCommand<String> {
    @Getter private double amount;
    @Getter private String currency;
    public WithdrawalAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount=amount;
        this.currency=currency;

    }
}
