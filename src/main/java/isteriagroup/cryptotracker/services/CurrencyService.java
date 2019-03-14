package isteriagroup.cryptotracker.services;


import isteriagroup.cryptotracker.daos.CurrencyDao;
import isteriagroup.cryptotracker.dtos.CurrencyDto;
import isteriagroup.cryptotracker.entities.Currency;
import org.springframework.stereotype.Service;


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

    private CurrencyDto buildCurrencyDtoFromCurrency(Currency currency){

        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(currency.getId());
        currencyDto.setName(currency.getName());
        currencyDto.setCurr_val(currency.getCurr_val());
        currencyDto.setLast_change(currency.getLast_change());

        return currencyDto;
    }
}
