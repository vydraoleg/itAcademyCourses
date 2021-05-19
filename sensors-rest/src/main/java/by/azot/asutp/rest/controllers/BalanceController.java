package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.BalanceDto;
import by.azot.asutp.api.dto.UserDto;
import by.azot.asutp.api.services.IBalanceService;
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
@RequestMapping(IControllerUrl.BALANCES)
public class BalanceController implements IControllerUrl {

    @Autowired
    private IBalanceService balanceService;

    @Autowired
    private IUserService userService;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @GetMapping(value = PAGE)
    public ModelAndView showBalances(@PathVariable int page) {

        List<BalanceDto> balances = balanceService.getBalances();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(BALANCESPAGE);
        modelAndView.addObject("title", "Balances:");

        Pagination<BalanceDto> balanceDtoPagination = new Pagination<BalanceDto>(balances, page, OBJECTBALANCESLIST, modelAndView);
        return balanceDtoPagination.getModelAndView();
    }

    @GetMapping
    public ModelAndView showBalancesFirstPage() {
        return this.showBalances(1);
    }

    @GetMapping(value = FINDID)
    public ModelAndView findBalance(@PathVariable Long id) {
        BalanceDto balanceDto = balanceService.findBalance(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(BALANCEPAGE);
        modelAndView.addObject(OBJECTBALANCE, balanceDto);
        return modelAndView;
    }

    @GetMapping(value = FIRSTNAME)
    public ModelAndView findBalanceByName(@PathVariable String firstName) {
        BalanceDto balanceDto = balanceService.findBalanceByName(firstName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(BALANCEPAGE);
        modelAndView.addObject(OBJECTBALANCE, balanceDto);
        return modelAndView;
    }

    //===============create=================

    @GetMapping(value = ADDPAGE)
    public ModelAndView createBalance() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(BALANCEFORMPAGE);
        modelAndView.addObject(OBJECTBALANCE, new BalanceDto());
        modelAndView.addObject("title", "Add new balance");
        return modelAndView;
    }

    @PostMapping(value = ADDPAGE)
    public String createBalanceSubmit(BalanceDto balance, Model model) {

        balance.setDateModified(new Date(System.currentTimeMillis()));
        String username = securityConfiguration.currentUserName();
        UserDto user = userService.findUserByUserName(username);
        balance.setModifiedByUser(user == null? ANONYMOUSUSER : user.getId());

        BalanceDto balanceDto = this.balanceService.createBalance(balance);
        return REDIRECTBALANCES;
    }

    // update

    @GetMapping(value = UPDATEID)
    public ModelAndView updateBalance(@PathVariable(value = "id") long id) {
        BalanceDto balanceDto = balanceService.findBalance(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(BALANCEPAGEUPDATE);
        modelAndView.addObject(OBJECTBALANCE, balanceDto);
        modelAndView.addObject("title", "Update balance:");
        return modelAndView;
    }

    @PostMapping(value = UPDATEID)
    public String updateBalance(@PathVariable(value = "id") long id, BalanceDto balance, @RequestParam(value = "file", required = false) MultipartFile file, Model model) {
        String username = securityConfiguration.currentUserName();
        UserDto user = userService.findUserByUserName(username);
        balance.setModifiedByUser(user == null? ANONYMOUSUSER : user.getId());
        this.balanceService.updateBalance(id, balance,file);
        return REDIRECTBALANCES;
    }

    @PostMapping(REMOVEID)
    public String deleteBalancePost(@PathVariable(value = "id") long id, Model model) {
        this.balanceService.deleteBalance(id);
        return REDIRECTBALANCES;
    }
}


