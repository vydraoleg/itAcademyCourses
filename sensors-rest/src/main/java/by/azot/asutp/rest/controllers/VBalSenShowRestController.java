package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.SensorDto;
import by.azot.asutp.api.dto.VBalSenShowDto;
import by.azot.asutp.api.services.ISensorService;
import by.azot.asutp.api.services.IVBalSenShowService;
import by.azot.asutp.rest.api.IControllerUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(IControllerUrl.RESTVBALSENSHOWS)
public class VBalSenShowRestController implements IControllerUrl {

    @Autowired
    private IVBalSenShowService vBalSenShowService;

    @GetMapping(value = "/{id}/{date}")
    public List<VBalSenShowDto> showVBalSenShow(@PathVariable Long id,@PathVariable String date) {
        return vBalSenShowService.getVBalSenShow(id, Date.valueOf(date));
    }

    @DeleteMapping(value = BALSENID)
    public void deleteBalanceSensor(@PathVariable Long idBalance,@PathVariable Long idSensor) {
        this.vBalSenShowService.deleteVBalSenShow(idBalance,idSensor);
    }
}
