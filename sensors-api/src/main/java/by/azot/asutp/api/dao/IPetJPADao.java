package by.azot.asutp.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import by.azot.asutp.entities.Pet;

public interface IPetJPADao extends JpaRepository<Pet, Long> {

}
