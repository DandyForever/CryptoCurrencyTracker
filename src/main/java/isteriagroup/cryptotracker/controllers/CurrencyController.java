package isteriagroup.cryptotracker.controllers;

import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.dtos.CurrencyDto;
import isteriagroup.cryptotracker.entities.Currency;
import isteriagroup.cryptotracker.services.CurrencyService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurrencyDto>> getAll() {
        return ResponseEntity.ok(currencyService.getAll());
    }

    @GetMapping("/{currencyId}")
    public CurrencyDto getCurrency(@PathVariable Long currencyId) throws ValidationException {
        return currencyService.getCurrency(currencyId);
    }

}