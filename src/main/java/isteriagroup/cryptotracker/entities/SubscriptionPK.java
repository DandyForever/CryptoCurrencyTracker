package isteriagroup.cryptotracker.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
public class SubscriptionPK implements Serializable {

    @Getter
    @Setter
    @Column(name = "USER_ID")
    @NotNull
    private Long userId;

    @Getter
    @Setter
    @Column (name = "CURRENCY_ID")
    @NotNull
    private Long currencyId;

    public SubscriptionPK (Long userId, Long currencyId){
        this.userId = userId;
        this.currencyId = currencyId;
    }
}
