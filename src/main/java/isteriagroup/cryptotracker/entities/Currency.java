package isteriagroup.cryptotracker.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "CURRENCIES")
@ToString(exclude = "currencies")
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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "currencies")
    @Getter
    @Setter
    private List<Subscribe> orders;

}
