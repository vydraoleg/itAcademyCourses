package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.VBalSenShowDto;
import by.azot.asutp.api.services.IVBalSenShowService;
import by.azot.asutp.rest.api.IControllerUrl;
import by.azot.asutp.rest.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(IControllerUrl.VBALSENSHOWS)
public class VBalSenShowController implements IControllerUrl {

    @Autowired
    private IVBalSenShowService vBalSenShowService;

    @GetMapping(value = DATEPAGE)
    public ModelAndView showVBalSenShow(@PathVariable(value = "id") Long id, @PathVariable(value = "date") String stringDate,@PathVariable(value = "page")  int page) {
        Date curDate = Date.valueOf(stringDate);
        List<VBalSenShowDto> vBalSenShow = vBalSenShowService.getVBalSenShow(curDate);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VBALSENSHOWSPAGE);
        modelAndView.addObject("title", vBalSenShow.get(0).getNameBalance());
        modelAndView.addObject("curDate", curDate);
        modelAndView.addObject("prevDate", curDate);
        modelAndView.addObject("nextDate", curDate);

        Pagination<VBalSenShowDto> vBalSenShowDtoPagination = new Pagination<VBalSenShowDto>(vBalSenShow, page, OBJECTVBALSENSHOWSLIST, modelAndView);
        return vBalSenShowDtoPagination.getModelAndView();
    }

    @GetMapping
    public ModelAndView showVBalSenShowFirstPage() { return this.showVBalSenShow(1L,"2021-04-12",1);  }

    @PostMapping(REMOVEID)
    public String deleteVBalSenShowPost(@PathVariable(value = "idBalance") long idBalance,@PathVariable(value = "id") long id, Model model) {
        this.vBalSenShowService.deleteVBalSenShow(idBalance,id);
        return REDIRECTVBALSENSHOWS;
    }
}


