package isteriagroup.cryptotracker.services;


import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.common.utils.ValidationUtils;
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

    public CurrencyDto getCurrency(Long currencyId) throws ValidationException {
        ValidationUtils.validateIsNotNull(currencyId, "No user id provided");

        Currency currency = currencyDao.findOne(currencyId);
        ValidationUtils.validateIsNotNull(currency, "No currency with Id " + currencyId);

        return buildCurrencyDtoFromCurrency(currency);
    }


}