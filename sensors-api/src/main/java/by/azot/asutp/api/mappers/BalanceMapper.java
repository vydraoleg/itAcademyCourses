package by.azot.asutp.api.mappers;

import by.azot.asutp.api.dto.BalanceDto;
import by.azot.asutp.entities.Balance;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class BalanceMapper {

    public Balance mapBalance(BalanceDto source) {
        return Balance.builder()
                .id(source.getId())
                .name(source.getName())
                .dateBegin(source.getDateBegin())
                .dateEnd(source.getDateEnd())
                .modifiedByUser(source.getModifiedByUser())
                .dateModified(source.getDateModified())
                .build();
    }

    public BalanceDto mapBalanceDto(Balance source) {
        return BalanceDto.builder()
                .id(source.getId())
                .name(source.getName())
                .dateBegin(source.getDateBegin())
                .dateEnd(source.getDateEnd())
                .modifiedByUser(source.getModifiedByUser())
                .dateModified(source.getDateModified())
                .build();
    }

    public List<Balance> mapBalances(List<BalanceDto> source) {
        return source.stream().map(BalanceMapper::mapBalance).collect(Collectors.toList());
    }
    
    public List<BalanceDto> mapBalanceDtos(List<Balance> source) {
        return source.stream().map(BalanceMapper::mapBalanceDto).collect(Collectors.toList());
    }
}
