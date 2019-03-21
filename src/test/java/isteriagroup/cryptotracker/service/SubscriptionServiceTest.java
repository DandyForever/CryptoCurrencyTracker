package isteriagroup.cryptotracker.service;


import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.daos.SubscriptionDao;
import isteriagroup.cryptotracker.dtos.SubscriptionDto;
import isteriagroup.cryptotracker.entities.Subscription;
import isteriagroup.cryptotracker.entities.SubscriptionPK;
import isteriagroup.cryptotracker.services.SubscriptionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionServiceTest {
    @Mock
    private SubscriptionDao subscriptionDao;

    private SubscriptionService subscriptionService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.subscriptionService = new SubscriptionService(subscriptionDao);
    }

    @Test(expected = ValidationException.class)
    public void wrongIdGetTest() throws ValidationException{
        given(subscriptionDao.findOne(new SubscriptionPK(1L, 1L))).willReturn(null);
        subscriptionService.get(new SubscriptionPK(1L, 1L));
    }

    @Test
    public void getTest() throws ValidationException{
        Subscription subscription = new Subscription(new SubscriptionPK((long) 1, (long) 1), (float) 1);
        given(subscriptionDao.findOne(new SubscriptionPK(1L, 1L))).willReturn(subscription);

        SubscriptionDto actualSubscriptionDto = subscriptionService.get(new SubscriptionPK(1L, 1L));
        SubscriptionDto expectedSubscriptionDto = new SubscriptionDto(new SubscriptionPK((long) 1, (long) 1), (float) 1);

        assertThat(actualSubscriptionDto).isEqualTo(expectedSubscriptionDto);
    }

    @Test(expected = ValidationException.class)
    public void nullCreateTest() throws ValidationException {
        subscriptionService.create(null);
    }

    @Test(expected = ValidationException.class)
    public void nullIdCreateTest() throws ValidationException{
        subscriptionService.create(new SubscriptionDto(new SubscriptionPK((long) 1, (long) 1), (float) 1));
    }

    @Test
    public void сreateTest() throws ValidationException{
        SubscriptionDto subscriptionDto = new SubscriptionDto(new SubscriptionPK((long) 1, (long) 1), (float) 1);

        Subscription actualSubscription = subscriptionService.create(subscriptionDto);

        Subscription expectedSubscription = new Subscription(new SubscriptionPK((long) 1, (long) 1), (float) 1);

        assertThat(actualSubscription).isEqualTo(expectedSubscription);
    }
}