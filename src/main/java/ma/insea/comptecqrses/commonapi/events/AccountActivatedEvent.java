package ma.insea.comptecqrses.commonapi.events;

import lombok.Getter;
import ma.insea.comptecqrses.commonapi.enums.AccountStatus;

import java.time.LocalDateTime;

public class AccountActivatedEvent extends BaseEvent<String> {
    @Getter private AccountStatus status;
    @Getter private LocalDateTime activateAt;

    public AccountActivatedEvent(String id, AccountStatus status) {
        super(id);
        this.status = status;
        this.activateAt =LocalDateTime.of(2022,6,15, 12,30,30);
        //this.activateAt=LocalDateTime.now();
    }
}
