package isteriagroup.cryptotracker.entities;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Currency;
import java.util.List;

@Entity
@Table(name = "USERS_SUBSCRIPTIONS")
@ToString
public class UsersSubscriptions {

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

}
