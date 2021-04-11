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
import by.azot.asutp.api.dto.SensorDto;
import by.azot.asutp.api.services.ISensorService;

@RestController
@RequestMapping("/pets")
public class SensorRestController {

    @Autowired
    private ISensorService sensorService;

    @GetMapping
    public List<SensorDto> findPets() {
        return sensorService.getSensors();
    }

    @GetMapping(value = "/{id}")
    public SensorDto findPet(@PathVariable Long id) {
        return sensorService.findSensor(id);
    }

    @PostMapping
    public SensorDto createPet(@RequestBody SensorDto pet) {
        return this.sensorService.createSensor(pet);
    }

    @PutMapping(value = "/{id}")
    public void updatePet(@PathVariable Long id, @RequestBody SensorDto pet) {
        this.sensorService.updateSensor(id, pet);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePet(@PathVariable Long id) {
        this.sensorService.deleteSensor(id);
    }
}
