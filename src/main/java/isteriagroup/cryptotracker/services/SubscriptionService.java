package isteriagroup.cryptotracker.services;


import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.daos.SubscriptionDao;
import isteriagroup.cryptotracker.dtos.CurrencyDto;
import isteriagroup.cryptotracker.dtos.SubscriptionDto;
import isteriagroup.cryptotracker.dtos.post.SubscriptionPostDto;
import isteriagroup.cryptotracker.entities.Subscription;
import isteriagroup.cryptotracker.entities.SubscriptionPK;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static isteriagroup.cryptotracker.common.utils.ValidationUtils.validateIsNotNull;
import static isteriagroup.cryptotracker.dtos.CurrencyDto.buildCurrencyDtoFromCurrency;



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
            CurrencyDto currencyDto = buildCurrencyDtoFromCurrency(subscription.getCurrency());

            return new SubscriptionDto(subscription.getSubscriptionPK(),
                    subscription.getUserVal(), currencyDto);
    }

    public Subscription create(SubscriptionDto subscriptionDto) throws ValidationException{
        validateIsNotNull(subscriptionDto, "No subscription is provided");
        validateIsNotNull(subscriptionDto.getSubscriptionPK(), "No PK specified for the subscription");

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

    public void createSubscription(Long currencyId) throws ValidationException {

//        log.info("Post" + currencyId);
        Long userId = 1L;

        validateIsNotNull(currencyId, "No currencyId provided");


        Subscription newSubscription = new Subscription(new SubscriptionPK(userId, currencyId), new BigDecimal(0));

        subscriptionDao.save(newSubscription);
    }

    public List<SubscriptionDto> getAll() {
        return subscriptionDao.findAllBy().stream()
                .map(this::buildSubscriptionDtoFromSubscription)
                .collect(Collectors.toList());
    }

    public void deleteSubscription(SubscriptionPostDto subscriptionPostDto) throws ValidationException{
        validateIsNotNull(subscriptionPostDto, "No subscriptionPostDto provided");

        SubscriptionPK subscriptionPK = new SubscriptionPK(subscriptionPostDto.getUserId(),
                subscriptionPostDto.getCurrencyId());

        subscriptionDao.delete(subscriptionPK);
    }

}