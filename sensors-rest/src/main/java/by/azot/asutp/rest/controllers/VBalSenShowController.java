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

    @GetMapping(value = IDDATEPAGE)
    public ModelAndView showVBalSenShow(@PathVariable(value = "id") Long id, @PathVariable(value = "date") String stringDate,@PathVariable(value = "page")  int page) {
        Long day = 24 * 3600 * 1000l;
        Date curDate = Date.valueOf(stringDate);
        List<VBalSenShowDto> vBalSenShow = vBalSenShowService.getVBalSenShow(id, curDate);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VBALSENSHOWSPAGE);
        modelAndView.addObject("title", vBalSenShow.get(0).getNameBalance());
        modelAndView.addObject("prevDate", new Date(curDate.getTime() - 1 * day)   );
        modelAndView.addObject("curDate", curDate);
        modelAndView.addObject("nextDate",new Date(curDate.getTime() + 1 * day) );
        Pagination<VBalSenShowDto> vBalSenShowDtoPagination = new Pagination<VBalSenShowDto>(vBalSenShow, page, OBJECTVBALSENSHOWSLIST, modelAndView);
        return vBalSenShowDtoPagination.getModelAndView();
    }

    @GetMapping
    public ModelAndView showVBalSenShowFirstPage() { return this.showVBalSenShow(1L,"2021-04-12",1);  }

    @PostMapping(REMOVEBALSEN)
    public String deleteVBalSenShowPost(@PathVariable(value = "balid") long idBalance,@PathVariable(value = "senid") long idSensor, Model model) {
        this.vBalSenShowService.deleteVBalSenShow(idBalance,idSensor);
        return REDIRECTVBALSENSHOWS;
    }
}


