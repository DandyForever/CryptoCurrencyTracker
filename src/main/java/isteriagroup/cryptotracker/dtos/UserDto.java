package isteriagroup.cryptotracker.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import isteriagroup.cryptotracker.entities.Subscription;
import lombok.*;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class UserDto {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private List<SubscriptionDto> subscriptions;

    public UserDto(Long id, String email, String name, List<SubscriptionDto> subscriptions) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.subscriptions = subscriptions;
    }
}