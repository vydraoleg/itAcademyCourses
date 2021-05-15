package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.SensorDto;
import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.services.ISensorService;
import by.azot.asutp.api.services.IUserService;
import by.azot.asutp.rest.api.IControllerUrl;
import by.azot.asutp.rest.configuration.SecurityConfiguration;
import by.azot.asutp.rest.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(IControllerUrl.SENSORS)
public class SensorController implements IControllerUrl {

    @Autowired
    private ISensorService sensorService;

    @Autowired
    private IUserService userService;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @GetMapping(value = PAGE)
    public ModelAndView showSensors(@PathVariable int page) {

        List<SensorDto> sensors = sensorService.getSensors();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(SENSORSPAGE);
        modelAndView.addObject("title", "Sensors:");

        Pagination<SensorDto> sensorDtoPagination = new Pagination<SensorDto>(sensors, page, OBJECTSENSORSLIST, modelAndView);
        return sensorDtoPagination.getModelAndView();
    }

    @GetMapping
    public ModelAndView showSensorsFirstPage() {
        return this.showSensors(1);
    }

    @GetMapping(value = FINDID)
    public ModelAndView findSensor(@PathVariable Long id) {
        SensorDto sensorDto = sensorService.findSensor(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(SENSORPAGE);
        modelAndView.addObject(OBJECTSENSOR, sensorDto);
        return modelAndView;
    }

    @GetMapping(value = FIRSTNAME)
    public ModelAndView findSensorByName(@PathVariable String firstName) {
        SensorDto sensorDto = sensorService.findSensorByName(firstName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(SENSORPAGE);
        modelAndView.addObject(OBJECTSENSOR, sensorDto);
        return modelAndView;
    }

    //===============create=================

    @GetMapping(value = ADDPAGE)
    public ModelAndView createSensor() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(SENSORFORMPAGE);
        modelAndView.addObject(OBJECTSENSOR, new SensorDto());
        modelAndView.addObject("title", "Add new sensor");
        return modelAndView;
    }

    @PostMapping(value = ADDPAGE)
    public String createSensorSubmit(SensorDto sensor, Model model) {

        sensor.setDateModified(new Date(System.currentTimeMillis()));
        String username = securityConfiguration.currentUserName();
        UserDto user = userService.findUserByUserName(username);
        sensor.setModifiedByUser(user == null? ANONYMOUSUSER : user.getId());

        SensorDto sensorDto = this.sensorService.createSensor(sensor);
        return REDIRECTSENSORS;
    }

    // update

    @GetMapping(value = UPDATEID)
    public ModelAndView updateSensor(@PathVariable(value = "id") long id) {
        SensorDto sensorDto = sensorService.findSensor(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(SENSORPAGEUPDATE);
        modelAndView.addObject(OBJECTSENSOR, sensorDto);
        modelAndView.addObject("title", "Update sensor:");
        return modelAndView;
    }

    @PostMapping(value = UPDATEID)
    public String updateUser(@PathVariable(value = "id") long id, SensorDto sensor, @RequestParam(value = "file", required = false) MultipartFile file, Model model) {
        sensor.setDateModified(new Date(System.currentTimeMillis()));
        String username = securityConfiguration.currentUserName();
        UserDto user = userService.findUserByUserName(username);
        sensor.setModifiedByUser(user == null? ANONYMOUSUSER : user.getId());
        this.sensorService.updateSensor(id, sensor,file);
        return REDIRECTSENSORS;
    }

    @PostMapping(REMOVEID)
    public String deleteSensorPost(@PathVariable(value = "id") long id, Model model) {
        this.sensorService.deleteSensor(id);
        return REDIRECTSENSORS;
    }
}


