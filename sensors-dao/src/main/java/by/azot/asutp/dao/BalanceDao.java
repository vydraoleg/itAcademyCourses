package by.azot.asutp.dao;

import by.azot.asutp.api.dao.IBalanceDao;
import by.azot.asutp.entities.Balance;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceDao extends AGenericDao<Balance> implements IBalanceDao {

    public BalanceDao() {
        super(Balance.class);
    }
}
