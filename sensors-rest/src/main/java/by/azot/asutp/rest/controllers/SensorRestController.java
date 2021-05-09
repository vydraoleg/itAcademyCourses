package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.SensorDto;
import by.azot.asutp.api.services.ISensorService;
import by.azot.asutp.rest.api.IControllerUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(IControllerUrl.RESTSENSORS)
public class SensorRestController implements IControllerUrl {

    @Autowired
    private ISensorService sensorService;

    @GetMapping
    public List<SensorDto> findSensors() {
        return sensorService.getSensors();
    }

    @GetMapping(value = FINDID)
    public SensorDto findSensor(@PathVariable Long id) {
        return sensorService.findSensor(id);
    }

    @PostMapping
    public SensorDto createSensor(@RequestBody SensorDto sensorDto) {
        return this.sensorService.createSensor(sensorDto);
    }

    @PutMapping(value = FINDID)
    public void updateSensor(@PathVariable Long id, @RequestBody SensorDto sensorDto) {
        this.sensorService.updateSensor(id, sensorDto);
    }

    @DeleteMapping(value = FINDID)
    public void deleteSensor(@PathVariable Long id) {
        this.sensorService.deleteSensor(id);
    }
}
