package isteriagroup.cryptotracker.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import isteriagroup.cryptotracker.entities.SubscriptionPK;
import lombok.*;


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
    private Float userVal;

    @Getter
    @Setter
    private CurrencyDto currencyDto;

    public SubscriptionDto(SubscriptionPK subscriptionPK, Float userVal) {
        this.subscriptionPK = subscriptionPK;
        this.userVal = userVal;
    }
}
