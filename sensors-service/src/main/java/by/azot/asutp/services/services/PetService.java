package by.azot.asutp.services.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.azot.asutp.api.dao.IPetDao;
import by.azot.asutp.api.dao.IPetJPADao;
import by.azot.asutp.api.dto.PetDto;
import by.azot.asutp.api.mappers.PetMapper;
import by.azot.asutp.api.services.IPetService;
import by.azot.asutp.entities.Pet;

@Service
public class PetService implements IPetService {

    @Autowired
    private IPetJPADao petDao;

    @Override
    public PetDto findPet(Long id) {
        Pet pet = this.petDao.findById(id).orElse(null);
        return (pet != null ) ? PetMapper.mapPetDto(pet) : null;
    }

    @Override
    @Transactional
    public PetDto createPet(PetDto pet) {
        Pet entity = PetMapper.mapPet(pet);
        return PetMapper.mapPetDto(this.petDao.save(entity));
    }

    @Override
    @Transactional
    public void updatePet(Long id, PetDto petDto) {
        Pet pet = this.petDao.findById(id).orElse(null);
        if(pet != null) {
            this.petDao.save(pet);
        }
    }

    @Override
    @Transactional
    public void deletePet(Long id) {
        this.petDao.deleteById(id);
    }

    @Override
    public List<PetDto> getPets() {
        return PetMapper.mapPetDtos(this.petDao.findAll());
    }
}
