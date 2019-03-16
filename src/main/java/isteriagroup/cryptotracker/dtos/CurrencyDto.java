package isteriagroup.cryptotracker.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import isteriagroup.cryptotracker.entities.Subscription;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
@NoArgsConstructor
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
    private BigDecimal curr_val;

    @Getter
    @Setter
    private BigDecimal last_change;

    @Getter
    @Setter
    private List<SubscriptionDto> subscriptions;

    public CurrencyDto(Long id, String name, BigDecimal curr_val, BigDecimal last_change, List<SubscriptionDto> subscriptions) {
        this.id = id;
        this.name = name;
        this.curr_val = curr_val;
        this.last_change = last_change;
        this.subscriptions = subscriptions;
    }
}