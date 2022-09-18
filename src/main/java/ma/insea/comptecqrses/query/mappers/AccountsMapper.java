package ma.insea.comptecqrses.query.mappers;

import ma.insea.comptecqrses.query.dtos.AccountDTO;
import ma.insea.comptecqrses.query.entities.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountsMapper {

    Account accountDTOToAccount(AccountDTO accountDTO) ;

    AccountDTO accountToClientDto(Account account) ;

    List<Account> accountDTOToAccountDTO(List<AccountDTO> accountsDTO) ;

    List<AccountDTO> accountToAccountDTO(List<Account> accounts) ;
}
