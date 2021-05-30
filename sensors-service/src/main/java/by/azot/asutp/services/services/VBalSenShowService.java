package by.azot.asutp.services.services;

import by.azot.asutp.api.dao.IVBalSenShowDao;
//import by.azot.asutp.api.dao.IVBalSenShowJPADao;
import by.azot.asutp.api.dao.IVBalSenShowJPADao;
import by.azot.asutp.api.dto.VBalSenShowDto;
import by.azot.asutp.api.mappers.VBalSenShowMapper;
import by.azot.asutp.api.services.IVBalSenShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Slf4j
public class VBalSenShowService implements IVBalSenShowService {

    @Autowired
    private IVBalSenShowJPADao vBalSenShowJPADao;

    @Autowired
    private IVBalSenShowDao vBalSenShowDao;

    @Override
    @Transactional
    public void deleteVBalSenShow(Long idBalance, Long id) {
            this.vBalSenShowJPADao.deleteVBalSenShow(idBalance, id);
    }

    @Override
    public List<VBalSenShowDto> getVBalSenShow(Long id, Date date) {
//        return VBalSenShowMapper.mapVBalSenShowDtos(this.vBalSenShowJPADao.findByDateValue(date));
        return VBalSenShowMapper.mapVBalSenShowDtos(this.vBalSenShowDao.findByIdDateValue(id, date));
    }
}
