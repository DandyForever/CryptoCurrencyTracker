package isteriagroup.cryptotracker.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS_SUBSCRIPTIONS")
@IdClass(SubscriptionPK.class)
@ToString(exclude = {"user", "currency"})
@NoArgsConstructor
public class Subscription {

    @Column(name = "USER_ID")
    @NotNull
    @Getter
    @Setter
    private Long userId;

    @Column(name = "CURRENCY_ID")
    @NotNull
    @Getter
    @Setter
    private Long currencyId;

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

    public Subscription(Float userVal, Long userId, Long currencyId) {
        this.userVal = userVal;
        this.userId = userId;
        this.currencyId = currencyId;
    }
}
