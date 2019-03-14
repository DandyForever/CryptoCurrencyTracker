package isteriagroup.cryptotracker.services;


import isteriagroup.cryptotracker.daos.CurrencyDao;
import isteriagroup.cryptotracker.dtos.CurrencyDto;
import isteriagroup.cryptotracker.entities.Currency;
import org.springframework.stereotype.Service;

import static isteriagroup.cryptotracker.dtos.CurrencyDto.buildCurrencyDtoFromCurrency;


@Service
public class CurrencyService {
    private CurrencyDao currencyDao;

    public CurrencyService(CurrencyDao currencyDao){
        this.currencyDao = currencyDao;
    }

    public CurrencyDto getCurrency(Long currencyId){
        Currency currency = currencyDao.findOne(currencyId);
        return buildCurrencyDtoFromCurrency(currency);
    }


}
