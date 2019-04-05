package isteriagroup.cryptotracker.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "SUBSCRIPTIONS")
@ToString(exclude = {"user", "currency"})
@NoArgsConstructor
@EqualsAndHashCode
public class Subscription{

    @EmbeddedId
    @Getter
    @Setter
    private SubscriptionPK subscriptionPK;

    @Column(name = "USER_VAL")
    @Getter
    @Setter
    private BigDecimal userVal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", insertable = false, updatable = false)
    @Getter
    @Setter
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID", insertable = false, updatable = false)
    @Getter
    @Setter
    private Currency currency;


    public Subscription(SubscriptionPK subscriptionPK, BigDecimal userVal) {
        this.subscriptionPK = subscriptionPK;
        this.userVal = userVal;
    }
}