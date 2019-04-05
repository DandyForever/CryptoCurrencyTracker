package isteriagroup.cryptotracker.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import isteriagroup.cryptotracker.entities.SubscriptionPK;
import lombok.*;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SubscriptionDto {

    @Getter
    @Setter
    private SubscriptionPK subscriptionPK;

    @Getter
    @Setter
    private BigDecimal userVal;

    @Getter
    @Setter
    private CurrencyDto currencyDto;

    public SubscriptionDto(SubscriptionPK subscriptionPK, BigDecimal userVal) {
        this.subscriptionPK = subscriptionPK;
        this.userVal = userVal;
    }
}