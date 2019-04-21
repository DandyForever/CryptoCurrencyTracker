package isteriagroup.cryptotracker.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import isteriagroup.cryptotracker.entities.Currency;
import lombok.*;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CurrencyDto {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private BigDecimal currVal;

    @Getter
    @Setter
    private BigDecimal lastChange;

    public CurrencyDto(Long id, String name, BigDecimal currVal, BigDecimal lastChange) {
        this.id = id;
        this.name = name;
        this.currVal = currVal;
        this.lastChange = lastChange;
    }

    public static CurrencyDto buildCurrencyDtoFromCurrency(Currency currency){

        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setId(currency.getId());
        currencyDto.setName(currency.getName());
        currencyDto.setCurrVal(currency.getCurrVal());
        currencyDto.setLastChange(currency.getLastChange());

        return currencyDto;
    }
}
