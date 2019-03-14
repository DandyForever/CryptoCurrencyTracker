package isteriagroup.cryptotracker.services;


import isteriagroup.cryptotracker.daos.SubscriptionDao;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private static final Logger log =
            LoggerFactory.getLogger(SubscriptionService.class);


    //не забыть убрать null
    private final SubscriptionDao subscriptionDao = null;
}