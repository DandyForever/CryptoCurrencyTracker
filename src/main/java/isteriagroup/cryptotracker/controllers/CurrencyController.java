package isteriagroup.cryptotracker.controllers;

import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.dtos.CurrencyDto;
import isteriagroup.cryptotracker.services.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/{currencyId}")
    public CurrencyDto getCurrency(@PathVariable Long currencyId) throws ValidationException {
        return currencyService.getCurrency(currencyId);
    }

}