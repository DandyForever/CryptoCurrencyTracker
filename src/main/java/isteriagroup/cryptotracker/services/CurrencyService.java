package isteriagroup.cryptotracker.services;


import isteriagroup.cryptotracker.daos.CurrencyDao;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    private CurrencyDao currencyDao;

    public CurrencyService(CurrencyDao currencyDao){
        this.currencyDao = currencyDao;
    }
}
