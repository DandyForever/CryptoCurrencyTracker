package isteriagroup.cryptotracker.service;


import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.daos.SubscriptionDao;
import isteriagroup.cryptotracker.services.SubscriptionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    /*@Test(expected = ValidationException.class)
    public void wrongIdGetTest() throws ValidationException{
        given(subscriptionDao.findOne(1L)).willReturn(null);
        subscriptionService.get(1L);
    }*/

}
