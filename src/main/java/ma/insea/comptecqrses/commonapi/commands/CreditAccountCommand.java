package ma.insea.comptecqrses.commonapi.commands;

public class CreditAccountCommand extends BaseCommand<String> {
    private double amount;
    private String currency;
    public CreditAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount=amount;
        this.currency=currency;

    }
}
