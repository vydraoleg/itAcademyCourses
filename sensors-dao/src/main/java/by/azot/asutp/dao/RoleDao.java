package by.azot.asutp.dao;

import by.azot.asutp.api.dao.IRoleDao;
import by.azot.asutp.entities.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends AGenericDao<Role> implements IRoleDao {

    public RoleDao() {    super(Role.class);
    }
}

