package isteriagroup.cryptotracker.controllers;


import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.dtos.SubscriptionDto;
import isteriagroup.cryptotracker.services.SubscriptionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import isteriagroup.cryptotracker.entities.SubscriptionPK;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/{subscriptionPK}")
    public SubscriptionDto getSubscription(@PathVariable SubscriptionPK subscriptionPK) throws ValidationException {
        return subscriptionService.get(subscriptionPK);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createSubscription(SubscriptionDto subscriptionDto) throws ValidationException {
        subscriptionService.create(subscriptionDto);
    }
}