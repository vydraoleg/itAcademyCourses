package by.azot.asutp.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import by.azot.asutp.api.dto.PetDto;
import by.azot.asutp.api.dto.UserDto;

@Service
public interface IPetService {

    PetDto findPet(Long id);
    
    PetDto createPet(PetDto user);
    
    void updatePet(Long id, PetDto user);
    
    void deletePet(Long id);
    
    List<PetDto> getPets();
}
