package by.azot.asutp.rest.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import by.azot.asutp.api.dto.PetDto;
import by.azot.asutp.api.services.IPetService;

@RestController
@RequestMapping("/pets")
public class PetRestController {

    @Autowired
    private IPetService petService;

    @GetMapping
    public List<PetDto> findPets() {
        return petService.getPets();
    }

    @GetMapping(value = "/{id}")
    public PetDto findPet(@PathVariable Long id) {
        return petService.findPet(id);
    }

    @PostMapping
    public PetDto createPet(@RequestBody PetDto pet) {
        return this.petService.createPet(pet);
    }

    @PutMapping(value = "/{id}")
    public void updatePet(@PathVariable Long id, @RequestBody PetDto pet) {
        this.petService.updatePet(id, pet);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePet(@PathVariable Long id) {
        this.petService.deletePet(id);
    }
}
