package isteriagroup.cryptotracker.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "CURRENCIES")
@ToString(exclude = "currencies")
@NoArgsConstructor
public class Currency {

    @Id
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "NAME")
    @NotNull
    @Getter
    @Setter
    private String name;

    @Column(name = "currVal")
    @Getter
    @Setter
    private BigDecimal currVal;

    @Column(name = "lastChange")
    @Getter
    @Setter
    private BigDecimal lastChange;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "currency")
    @Getter
    @Setter
    private List<Subscription> subscriptions;


    public Currency(String name, BigDecimal currVal, BigDecimal lastChange, List<Subscription> subscriptions) {
        this.name = name;
        this.currVal = currVal;
        this.lastChange = lastChange;
        this.subscriptions = subscriptions;
    }

    public Currency(Long id, String name, BigDecimal currVal, BigDecimal lastChange) {
        this.id = id;
        this.name = name;
        this.currVal = currVal;
        this.lastChange = lastChange;
    }

}
