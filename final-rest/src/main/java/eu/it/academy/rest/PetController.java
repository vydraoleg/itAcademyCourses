package eu.it.academy.rest;

import java.util.List;

import eu.it.academy.api.dto.UserPetIdsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import eu.it.academy.api.dto.PetDto;
import eu.it.academy.api.services.IPetService;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private IPetService petService;

    @GetMapping
    public List<PetDto> findPets() {
        return petService.getPets();
    }

    @GetMapping(value = "/{id}")
    public PetDto findPet(@PathVariable int id) {
        return petService.findPet(id);
    }

    @PostMapping
    public PetDto createPet(@RequestBody PetDto pet) {
        return this.petService.createPet(pet);
    }

    @PutMapping(value = "/{id}")
    public void updatePet(@PathVariable int id, @RequestBody PetDto pet) {
        this.petService.updatePet(id, pet);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePet(@PathVariable int id) {
        this.petService.deletePet(id);
    }

    @PatchMapping()
    public void assignUserToPet(@RequestBody UserPetIdsDto ids) {
        this.petService.assignUserToPet(ids);
    }
}
