package isteriagroup.cryptotracker.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
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

    public CurrencyDto(Long id, String name, BigDecimal curr_val, BigDecimal last_change) {
        this.id = id;
        this.name = name;
        this.curr_val = curr_val;
        this.last_change = last_change;
    }
}
