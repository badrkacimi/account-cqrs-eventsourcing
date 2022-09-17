package ma.insea.comptecqrses.commonapi.events;

import lombok.Getter;
import ma.insea.comptecqrses.commonapi.enums.AccountStatus;

import java.util.Date;

public class AccountActivatedEvent extends BaseEvent<String> {
    @Getter private AccountStatus status;
    @Getter private Date activateAt;

    public AccountActivatedEvent(String id, AccountStatus status) {
        super(id);
        this.status = status;
        this.activateAt=new Date();
    }
}
