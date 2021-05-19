package by.azot.asutp.api.services;

import by.azot.asutp.api.dto.BalanceDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface IBalanceService {

    BalanceDto findBalance(Long id);

    BalanceDto findBalanceByName(String firstName);

    BalanceDto createBalance(BalanceDto balanceDto);
    
    void updateBalance(Long id, BalanceDto BalanceDto, MultipartFile file);

    void updateBalance(Long id, BalanceDto BalanceDto);

    void deleteBalance(Long id);
    
    List<BalanceDto> getBalances();
}
