package ma.insea.comptecqrses.commonapi.commands;

public class WithdrawlAccountCommand extends BaseCommand<String> {
    private double amount;
    private String currency;
    public WithdrawlAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount=amount;
        this.currency=currency;

    }
}
