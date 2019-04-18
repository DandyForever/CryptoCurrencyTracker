package isteriagroup.cryptotracker.controllers;


import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.dtos.SubscriptionDto;
import isteriagroup.cryptotracker.services.SubscriptionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import isteriagroup.cryptotracker.entities.SubscriptionPK;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @RequestMapping("/subscription")
    public SubscriptionDto getSubscription(@RequestParam(value = "userId", required = false) Long userId,
                                           @RequestParam(value = "currencyId", required = false) Long currencyId) throws ValidationException {
        
        return subscriptionService.get(new SubscriptionPK(userId, currencyId));
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createSubscription(SubscriptionDto subscriptionDto) throws ValidationException {
        subscriptionService.create(subscriptionDto);
    }

    @PostMapping(value = "create_subscription")
    public void createSubscription(@RequestParam("currencyId") Long currencyId) throws ValidationException {
        subscriptionService.createSubscription(currencyId);
    }
}
