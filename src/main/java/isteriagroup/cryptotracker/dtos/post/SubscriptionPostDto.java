package isteriagroup.cryptotracker.dtos.post;


import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SubscriptionPostDto {
    @Getter
    @Setter
    private long currencyId;

    @Getter
    @Setter
    private long userId;

    public SubscriptionPostDto(long currencyId, long userId) {
        this.currencyId = currencyId;
        this.userId = userId;
    }
}
