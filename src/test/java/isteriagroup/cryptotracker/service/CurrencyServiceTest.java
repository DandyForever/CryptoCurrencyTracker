package isteriagroup.cryptotracker.service;

import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.daos.CurrencyDao;
import isteriagroup.cryptotracker.daos.SubscriptionDao;
import isteriagroup.cryptotracker.dtos.CurrencyDto;
import isteriagroup.cryptotracker.dtos.SubscriptionDto;
import isteriagroup.cryptotracker.entities.Currency;
import isteriagroup.cryptotracker.entities.Subscription;
import isteriagroup.cryptotracker.services.CurrencyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyServiceTest {
    @Mock
    private CurrencyDao currencyDao;

    private CurrencyService currencyService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.currencyService = new CurrencyService(currencyDao);
    }

    @Test(expected = ValidationException.class)
    public void wrongIdGetTest() throws ValidationException{
        given(currencyDao.findOne(1L)).willReturn(null);
        currencyService.getCurrency(1L);
    }

    @Test
    public void getTest() throws ValidationException{
        Subscription subscription1 = new Subscription((float) 10.0, 1L, 1L);
        Subscription subscription2 = new Subscription((float) 20.0, 2L, 1L);
        List<Subscription> subscriptions = new ArrayList<Subscription>();
        subscriptions.add(subscription1);
        subscriptions.add(subscription2);
        Currency currency = new Currency("Bitcoin", new BigDecimal(100), new BigDecimal(5), subscriptions);

        given(currencyDao.findOne(1L)).willReturn(currency);

        CurrencyDto actualCurrencyDto = currencyService.getCurrency(1L);

        SubscriptionDto subscriptionDto1 = new SubscriptionDto(1L, (float) 10, 1L);
        SubscriptionDto subscriptionDto2 = new SubscriptionDto(2L, (float) 20, 1L);
        List <SubscriptionDto> subscriptionDtos = new ArrayList<>();
        subscriptionDtos.add(subscriptionDto1);
        subscriptionDtos.add(subscriptionDto2);
        CurrencyDto expectedCurrencyDto = new CurrencyDto(1L, "Bitcoin", new BigDecimal(100), new BigDecimal(5));

        assertThat(actualCurrencyDto).isEqualTo(expectedCurrencyDto);
    }
}
