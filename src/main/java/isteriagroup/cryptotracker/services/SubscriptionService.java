package isteriagroup.cryptotracker.services;


import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.daos.SubscriptionDao;
import isteriagroup.cryptotracker.dtos.SubscriptionDto;
import isteriagroup.cryptotracker.entities.Subscription;
import isteriagroup.cryptotracker.entities.SubscriptionPK;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static isteriagroup.cryptotracker.common.utils.ValidationUtils.validateIsNotNull;
import static isteriagroup.cryptotracker.common.utils.ValidationUtils.validateIsNull;


@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private static final Logger log =
            LoggerFactory.getLogger(SubscriptionService.class);

    private final SubscriptionDao subscriptionDao;

    public SubscriptionDto get(SubscriptionPK subscriptionPK) throws ValidationException {
        validateIsNotNull(subscriptionPK, "No subscription is provided");

        Subscription subscription = subscriptionDao.findOne(subscriptionPK);
        validateIsNotNull(subscription, "No subscription with id" + subscriptionPK);

        return buildSubscriptionDtoFromSubscription(subscription);
    }

   private SubscriptionDto buildSubscriptionDtoFromSubscription(Subscription subscription){
        return new SubscriptionDto(subscription.getSubscriptionPK(),
                subscription.getUserVal());

   }

   public Subscription create(SubscriptionDto subscriptionDto) throws ValidationException{
        validateIsNotNull(subscriptionDto, "No subscription is provided");
        validateIsNull(subscriptionDto.getSubscriptionPK(), "No PK specified for the subscription");

        Subscription subscription = buildSubscriptionFromSubscriptionDto(subscriptionDto);
        subscriptionDao.save(subscription);

        return subscription;
   }

    private Subscription buildSubscriptionFromSubscriptionDto(SubscriptionDto subscriptionDto) {
        Subscription subscription = new Subscription();
        subscription.setSubscriptionPK(subscriptionDto.getSubscriptionPK());
        subscription.setUserVal(subscriptionDto.getUserVal());

        return subscription;
    }
}
