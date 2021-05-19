package by.azot.asutp.services.services;

import by.azot.asutp.api.dao.IBalanceJPADao;
import by.azot.asutp.api.dto.BalanceDto;
import by.azot.asutp.api.mappers.BalanceMapper;
import by.azot.asutp.api.services.IBalanceService;
import by.azot.asutp.entities.Balance;
import by.azot.asutp.services.utils.LogoFileUploader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class BalanceService implements IBalanceService {

    @Autowired
    private IBalanceJPADao balanceDao;

    // TODO
    @Override
    public BalanceDto findBalance(Long id) {
        Balance balance = this.balanceDao.findById(id).orElse(null);
        return (balance != null ) ? BalanceMapper.mapBalanceDto(balance) : null;
    }

    @Override
    public BalanceDto findBalanceByName(String curName) {
        return BalanceMapper.mapBalanceDto(this.balanceDao.findByName(curName));
    }

    @Override
    @Transactional
    public BalanceDto createBalance(BalanceDto balance) {
        Balance entity = BalanceMapper.mapBalance(balance);
        return BalanceMapper.mapBalanceDto(this.balanceDao.save(entity));
    }

    @Override
    @Transactional
    public void updateBalance(Long id, BalanceDto balanceDto, MultipartFile file) {
        Balance balance = this.balanceDao.findById(id).orElse(null);
        if(balance != null) {
            balance = BalanceMapper.mapBalance(balanceDto);
            balance.setId(id);
            this.balanceDao.save(balance);
        }
        if (!file.isEmpty()) {
            try {
                LogoFileUploader.updateOrCreateLogo(file, balanceDto.getName());
            } catch (IOException e) {
                log.error("Failed to upload image. Error message: {}", e.getMessage());
            }
        }
    }

    @Override
    @Transactional
    public void updateBalance(Long id, BalanceDto balanceDto) {
        Balance balance = this.balanceDao.findById(id).orElse(null);
        if(balance != null) {
            balance = BalanceMapper.mapBalance(balanceDto);
            balance.setId(id);
            this.balanceDao.save(balance);
        }
    }

    @Override
    @Transactional
    public void deleteBalance(Long id) {
        this.balanceDao.deleteById(id);
    }

    @Override
    public List<BalanceDto> getBalances() {
        return BalanceMapper.mapBalanceDtos(this.balanceDao.findAll(Sort.by("name").ascending()));
    }
}
