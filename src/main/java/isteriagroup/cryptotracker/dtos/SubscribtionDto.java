package isteriagroup.cryptotracker.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SubscribtionDto {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Long userId;

    @Getter
    @Setter
    private Float userVal;

    @Getter
    @Setter
    private CurrencyDto currency;

    public SubscribtionDto(Long id, Long userId, Float userVal, CurrencyDto currency) {
        this.id = id;
        this.userId = userId;
        this.userVal = userVal;
        this.currency = currency;
    }
}
