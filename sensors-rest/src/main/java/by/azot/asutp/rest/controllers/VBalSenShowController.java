package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.SensorDto;
import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.dto.VBalSenShowDto;
import by.azot.asutp.api.services.ISensorService;
import by.azot.asutp.api.services.IUserService;
import by.azot.asutp.api.services.IVBalSenShowService;
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
@RequestMapping(IControllerUrl.VBALSENSHOWS)
public class VBalSenShowController implements IControllerUrl {

    @Autowired
    private IVBalSenShowService vBalSenShowService;

    @GetMapping(value = DATEPAGE)
    public ModelAndView showVBalSenShow(@PathVariable(value = "date") String stringDate,@PathVariable(value = "page")  int page) {

        List<VBalSenShowDto> vBalSenShow = vBalSenShowService.getVBalSenShow(Date.valueOf(stringDate) );
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VBALSENSHOWSPAGE);
        modelAndView.addObject("title", vBalSenShow.get(0).getNameBalance());

        Pagination<VBalSenShowDto> vBalSenShowDtoPagination = new Pagination<VBalSenShowDto>(vBalSenShow, page, OBJECTVBALSENSHOWSLIST, modelAndView);
        return vBalSenShowDtoPagination.getModelAndView();
    }

    @GetMapping
    public ModelAndView showVBalSenShowFirstPage() { return this.showVBalSenShow("2021-04-12",1);  }

    @PostMapping(REMOVEID)
    public String deleteVBalSenShowPost(@PathVariable(value = "idBalance") long idBalance,@PathVariable(value = "id") long id, Model model) {
        this.vBalSenShowService.deleteVBalSenShow(idBalance,id);
        return REDIRECTVBALSENSHOWS;
    }
}


