package by.azot.asutp.api.dao;

import by.azot.asutp.entities.VBalSenShow;

import java.sql.Date;
import java.util.List;

public interface IVBalSenShowDao extends IAGenericDao<VBalSenShow> {

    List<VBalSenShow> findByIdDateValue(Long id, Date date);

}
