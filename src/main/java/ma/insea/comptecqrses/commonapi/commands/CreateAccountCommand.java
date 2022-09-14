package ma.insea.comptecqrses.commonapi.commands;

import lombok.Getter;

public class CreateAccountCommand extends BaseCommand<String> {
    @Getter private double initialBalance;
    @Getter private String currency;
    public CreateAccountCommand(String id,double initialBalance,String currency) {
        super(id);
        this.initialBalance=initialBalance;
        this.currency=currency;

    }
}
