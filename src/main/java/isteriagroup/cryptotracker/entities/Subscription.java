package isteriagroup.cryptotracker.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS_SUBSCRIPTIONS")
@ToString(exclude = {"user", "currency"})
@NoArgsConstructor
public class Subscription {

    @Id
    @Column(name = "USER_CURRENCY_PK")
    @Getter
    @Setter
    private SubscriptionPK subscriptionPK;


    @Column(name = "USER_VAL")
    @Getter
    @Setter
    private Float userVal;

    @Column(name = "USER_ID")
    @NotNull
    @Getter
    @Setter
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", insertable = false, updatable = false)
    @Getter
    @Setter
    private User user;

    @Column(name = "CURRENCY_ID")
    @NotNull
    @Getter
    @Setter
    private Long currencyId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID", insertable = false, updatable = false)
    @Getter
    @Setter
    private Currency currency;

    public Subscription(Float userVal, Long userId, Long currencyId) {
        this.userVal = userVal;
        this.userId = userId;
        this.currencyId = currencyId;
    }

}