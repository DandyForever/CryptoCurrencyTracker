package isteriagroup.cryptotracker.controllers;


import isteriagroup.cryptotracker.daos.CurrencyDao;
import isteriagroup.cryptotracker.entities.Currency;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency")
public class CurrencyController {
    private CurrencyDao currencyDao;

    public CurrencyController(CurrencyDao currencyDao){
        this.currencyDao = currencyDao;
    }

    @GetMapping("/all")
    public Iterable<Currency> all(){
        return this.currencyDao.findAll();
    }
}
