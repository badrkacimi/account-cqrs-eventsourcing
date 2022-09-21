package ma.insea.comptecqrses.commands.aggregates;

import ma.insea.comptecqrses.commonapi.commands.CreateAccountCommand;
import ma.insea.comptecqrses.commonapi.commands.CreditAccountCommand;
import ma.insea.comptecqrses.commonapi.commands.WithdrawalAccountCommand;
import ma.insea.comptecqrses.commonapi.enums.AccountStatus;
import ma.insea.comptecqrses.commonapi.events.AccountActivatedEvent;
import ma.insea.comptecqrses.commonapi.events.AccountCreatedEvent;
import ma.insea.comptecqrses.commonapi.events.AccountCreditedEvent;
import ma.insea.comptecqrses.commonapi.events.AccountWithdrawnEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

class AccountAggregateTest {

    private static final String ACCOUNT_ID = UUID.randomUUID().toString().replace("-", "").substring(8, 17);
    private FixtureConfiguration<AccountAggregate> fixture;
    LocalDateTime NOW;

    @BeforeEach
    public void setUp() {
        NOW = LocalDateTime.of(2022,6,15, 12,30,30);
        fixture = new AggregateTestFixture<>(AccountAggregate.class);
    }

    @Test
    void giveNoPriorActivity_whenCreateAccountCommand_thenShouldPublishAccountCreatedEvent() {
        CreateAccountCommand createAccountCommand = new CreateAccountCommand(ACCOUNT_ID, 10000, "MAD");
        AccountCreatedEvent accountCreatedEvent = new AccountCreatedEvent(createAccountCommand.getId(),
                createAccountCommand.getInitialBalance(),
                createAccountCommand.getCurrency(),
                AccountStatus.CREATED,
                NOW);
        AccountActivatedEvent accountActivatedEvent = new AccountActivatedEvent(ACCOUNT_ID, AccountStatus.ACTIVATED);
        fixture.givenNoPriorActivity()
                .when(createAccountCommand)
                .expectEvents(accountCreatedEvent, accountActivatedEvent);
    }

    @Test
    void givenCreditedEvent_whenCreditAccountCommand_thenShouldPublishAccountCreditedEvent() {
        LocalDateTime NOW = LocalDateTime.of(2022,6,15, 12,30,30);
        CreditAccountCommand creditAccountCommand = new CreditAccountCommand(ACCOUNT_ID,10000,"MAD");
        AccountCreditedEvent accountCreditedEvent =new AccountCreditedEvent(
                creditAccountCommand.getId(),
                creditAccountCommand.getAmount(),
                creditAccountCommand.getCurrency(),
                NOW);
        fixture.given(accountCreditedEvent)
                .when(creditAccountCommand)
                .expectEvents(accountCreditedEvent);
    }

    @Test
    void givenWithdrawnEvent_whenWithdrawAccountCommand_thenShouldPublishAccountWithdrawnEvent() {
        LocalDateTime NOW = LocalDateTime.of(2022,6,15, 12,30,30);
        WithdrawalAccountCommand withdrawalAccountCommand = new WithdrawalAccountCommand(ACCOUNT_ID,10000,"MAD");
         AccountWithdrawnEvent accountCreditedEvent =new AccountWithdrawnEvent(
                 withdrawalAccountCommand.getId(),
                 withdrawalAccountCommand.getAmount(),
                 withdrawalAccountCommand.getCurrency(),
                 NOW);
        fixture.given(accountCreditedEvent)
                .when(withdrawalAccountCommand)
                .expectEvents(accountCreditedEvent);
    }
}