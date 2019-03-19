package isteriagroup.cryptotracker.entities;


import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

public class SubscriptionPK implements Serializable {
    @Getter
    @Setter
    private Long userId;

    @Getter
    @Setter
    private Long currencyId;

    public SubscriptionPK(Long userId, Long currencyId) {
        this.userId = userId;
        this.currencyId = currencyId;
    }
}
