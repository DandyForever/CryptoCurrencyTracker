package isteriagroup.cryptotracker.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SubscriptionDto {

    @Getter
    @Setter
    private Long userId;

    @Getter
    @Setter
    private Float userVal;

    @Getter
    @Setter
    private CurrencyDto currencyDto;

    @Getter
    @Setter
    private Long currencyId;

    public SubscriptionDto(Long userId, Float userVal, Long currencyId) {
        this.userId = userId;
        this.userVal = userVal;
        this.currencyId = currencyId;
    }
}
