package isteriagroup.cryptotracker.services;


import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.common.utils.ValidationUtils;
import isteriagroup.cryptotracker.daos.CurrencyDao;
import isteriagroup.cryptotracker.dtos.CurrencyDto;
import isteriagroup.cryptotracker.entities.Currency;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<CurrencyDto> getAll() {
        return currencyDao.findAllBy().stream()
                .map(this::buildCurrencyDto)
                .collect(Collectors.toList());
    }

    private CurrencyDto buildCurrencyDto(Currency currency) {
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(currency.getId());
        currencyDto.setName(currency.getName());
        currencyDto.setCurrVal(currency.getCurr_val());
        currencyDto.setLastChange(currency.getLast_change());

        return currencyDto;
    }


}