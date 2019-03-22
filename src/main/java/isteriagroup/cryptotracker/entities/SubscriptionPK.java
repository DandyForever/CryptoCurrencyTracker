package isteriagroup.cryptotracker.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class SubscriptionPK implements Serializable {

    @Column(name = "USER_ID", insertable = false, updatable = false)
    @NotNull
    @Getter
    @Setter
    private Long userId;

    @Column(name = "CURRENCY_ID", insertable = false, updatable = false)
    @NotNull
    @Getter
    @Setter
    private Long currencyId;

    public SubscriptionPK(Long userId, Long currencyId) {
        this.userId = userId;
        this.currencyId = currencyId;
    }
    
    public SubscriptionPK() {
    }
}
