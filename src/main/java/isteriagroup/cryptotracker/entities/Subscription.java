package isteriagroup.cryptotracker.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "SUBSCRIPTIONS")
@ToString(exclude = {"user", "currency"})
@NoArgsConstructor
public class Subscription{

    @EmbeddedId
    @Getter
    @Setter
    private SubscriptionPK subscriptionPK;

    @Column(name = "USER_VAL")
    @Getter
    @Setter
    private Float userVal;

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


    public Subscription(SubscriptionPK subscriptionPK, Float userVal) {
        this.subscriptionPK = subscriptionPK;
        this.userVal = userVal;
    }
}
