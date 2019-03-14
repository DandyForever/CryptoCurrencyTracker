package isteriagroup.cryptotracker.services;


import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.daos.SubscriptionDao;
import isteriagroup.cryptotracker.dtos.CurrencyDto;
import isteriagroup.cryptotracker.dtos.SubscribtionDto;
import isteriagroup.cryptotracker.entities.Currency;
import isteriagroup.cryptotracker.entities.Subscription;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static isteriagroup.cryptotracker.common.utils.ValidationUtils.validateIsNotNull;
import static isteriagroup.cryptotracker.common.utils.ValidationUtils.validateIsNull;
import static isteriagroup.cryptotracker.dtos.CurrencyDto.buildCurrencyDtoFromCurrency;


@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private static final Logger log =
            LoggerFactory.getLogger(SubscriptionService.class);

    private final SubscriptionDao subscriptionDao;

    public SubscribtionDto get(Long subscriptionId) throws ValidationException {
        validateIsNotNull(subscriptionId, "No subsription is provided");

        Subscription subscription = subscriptionDao.findOne(subscriptionId);
        validateIsNotNull(subscription, "No subscription with id" + subscriptionId);

        return buildSubscribtionDtoFromSubscription(subscription);
    }

   private SubscribtionDto buildSubscribtionDtoFromSubscription(Subscription subscription){
        return new SubscribtionDto(subscription.getUserId(),
                subscription.getUserVal(),
                subscription.getCurrencyId());

   }

   public Subscription create(SubscribtionDto subscribtionDto) throws ValidationException{
        validateIsNotNull(subscribtionDto, "No subscription is provided");
        validateIsNull(subscribtionDto.getUserId(), "No user specified for the subscription");

        Subscription subscription = buildSubsriptionFromSubscribtionDto(subscribtionDto);
        subscriptionDao.save(subscription);

        subscription.setCurrency(buildCurrencyFromCurrencyDto(subscribtionDto.getCurrency()));


        subscriptionDao.save(subscription);

        return subscription;
   }

    private Subscription buildSubsriptionFromSubscribtionDto(SubscribtionDto subscribtionDto) {
        Subscription subscription = new Subscription();
        subscription.setCurrency(buildCurrencyFromCurrencyDto(subscribtionDto.getCurrency()));

        return subscription;
    }

    private Currency buildCurrencyFromCurrencyDto(CurrencyDto currencyDto) {
        Currency currency = new Currency();

        currency.setCurr_val(currencyDto.getCurr_val());
        currency.setLast_change(currencyDto.getLast_change());
        currency.setName(currencyDto.getName());
        currency.setId(currencyDto.getId());

        return currency;
    }
}
