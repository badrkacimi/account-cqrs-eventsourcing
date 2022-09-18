package ma.insea.comptecqrses.query.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.insea.comptecqrses.commonapi.enums.OperationTypes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Operations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double amount;
    private Date operationDate;
    @Enumerated(EnumType.STRING)
    private OperationTypes operationType;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Account account;
}
