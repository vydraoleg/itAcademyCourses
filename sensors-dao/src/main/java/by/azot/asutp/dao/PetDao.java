package by.azot.asutp.dao;

import org.springframework.stereotype.Repository;
import by.azot.asutp.api.dao.IPetDao;
import by.azot.asutp.entities.Pet;

@Repository
public class PetDao extends AGenericDao<Pet> implements IPetDao {

    public PetDao() {
        super(Pet.class);
    }
}
