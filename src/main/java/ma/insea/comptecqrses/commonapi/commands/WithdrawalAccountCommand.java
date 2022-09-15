package ma.insea.comptecqrses.commonapi.commands;

public class WithdrawalAccountCommand extends BaseCommand<String> {
    private double amount;
    private String currency;
    public WithdrawalAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount=amount;
        this.currency=currency;

    }
}
