package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.SensorDto;
import by.azot.asutp.api.services.ISensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/sensors")
public class SensorRestController {

    @Autowired
    private ISensorService sensorService;

    @GetMapping
    public List<SensorDto> findSensors() {
        return sensorService.getSensors();
    }

    @GetMapping(value = "/{id}")
    public SensorDto findSensor(@PathVariable Long id) {
        return sensorService.findSensor(id);
    }

    @PostMapping
    public SensorDto createSensor(@RequestBody SensorDto sensorDto) {
        return this.sensorService.createSensor(sensorDto);
    }

    @PutMapping(value = "/{id}")
    public void updateSensor(@PathVariable Long id, @RequestBody SensorDto sensorDto) {
        this.sensorService.updateSensor(id, sensorDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSensor(@PathVariable Long id) {
        this.sensorService.deleteSensor(id);
    }
}
