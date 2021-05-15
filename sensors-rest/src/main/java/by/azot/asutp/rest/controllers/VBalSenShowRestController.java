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

    @GetMapping
    public List<VBalSenShowDto> showVBalSenShow(String stringDate) {
        return vBalSenShowService.getVBalSenShow(Date.valueOf(stringDate));
    }
}
