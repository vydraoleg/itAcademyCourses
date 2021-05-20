package by.azot.asutp.api.services;

import by.azot.asutp.api.dto.VBalSenShowDto;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface IVBalSenShowService {

    void deleteVBalSenShow(Long idBalance,Long id);

    List<VBalSenShowDto> getVBalSenShow(Date date);

}
