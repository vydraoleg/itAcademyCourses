package by.azot.asutp.rest.controllers;

import by.azot.asutp.api.dto.BalanceDto;
import by.azot.asutp.api.dto.SensorDto;
import by.azot.asutp.api.services.IBalanceService;
import by.azot.asutp.api.services.ISensorService;
import by.azot.asutp.rest.api.IControllerUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(IControllerUrl.RESTBALANCES)
public class BalanceRestController implements IControllerUrl {

    @Autowired
    private IBalanceService balanceService;

    @GetMapping
    public List<BalanceDto> findBalances() {
        return balanceService.getBalances();
    }

    @GetMapping(value = FINDID)
    public BalanceDto findBalance(@PathVariable Long id) {
        return balanceService.findBalance(id);
    }

    @PostMapping
    public BalanceDto createBalance(@RequestBody BalanceDto balanceDto) {
        return this.balanceService.createBalance(balanceDto);
    }

    @PutMapping(value = FINDID)
    public void updateBalance(@PathVariable Long id, @RequestBody BalanceDto balanceDto) {
        this.balanceService.updateBalance(id, balanceDto);
    }

    @DeleteMapping(value = FINDID)
    public void deleteBalance(@PathVariable Long id) {
        this.balanceService.deleteBalance(id);
    }
}
