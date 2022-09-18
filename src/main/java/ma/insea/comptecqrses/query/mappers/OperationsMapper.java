package ma.insea.comptecqrses.query.mappers;

import ma.insea.comptecqrses.query.dtos.OperationDTO;
import ma.insea.comptecqrses.query.entities.Operation;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {AccountsMapper.class},  injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OperationsMapper {

    OperationDTO operationToOperationDto(Operation operation) ;

    Operation OperationDtoToOperation(OperationDTO operationDTO) ;

    List<OperationDTO> operationToOperationDto(List<Operation> operations) ;

    List<Operation> OperationDtoToOperation(List<OperationDTO> operationsDTOS) ;
}
