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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "currency_seq_gen")
    @SequenceGenerator(name = "currency_seq_gen",
            sequenceName = "user_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    @NotNull
    @Getter
    @Setter
    private String name;

    @Column(name = "CURR_VAL")
    @Getter
    @Setter
    private BigDecimal curr_val;

    @Column(name = "LAST_CHANGE")
    @Getter
    @Setter
    private BigDecimal last_change;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "currency")
    @Getter
    @Setter
    private List<Subscription> subscriptions;


    public Currency(String name, BigDecimal curr_val, BigDecimal last_change, List<Subscription> subscriptions) {
        this.name = name;
        this.curr_val = curr_val;
        this.last_change = last_change;
        this.subscriptions = subscriptions;
    }

    public Currency(String name, BigDecimal curr_val, BigDecimal last_change) {
        this.name = name;
        this.curr_val = curr_val;
        this.last_change = last_change;
    }

}
