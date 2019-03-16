package isteriagroup.cryptotracker.service;

import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.daos.UserDao;
import isteriagroup.cryptotracker.dtos.SubscriptionDto;
import isteriagroup.cryptotracker.dtos.UserDto;
import isteriagroup.cryptotracker.entities.Subscription;
import isteriagroup.cryptotracker.entities.User;
import isteriagroup.cryptotracker.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Mock
    private UserDao userDao;

    private UserService userService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.userService = new UserService(userDao);
    }

    @Test(expected = ValidationException.class)
    public void wrongIdGetTest() throws ValidationException{
        given(userDao.findOne(1L)).willReturn(null);
        userService.getUser(1L);
    }

    @Test(expected = ValidationException.class)
    public void wrongEmailGetTest() throws ValidationException{
        given(userDao.findByEmail("crypto@mail.ru")).willReturn(null);
        userService.getUserByEmail("crypto@mail.ru");
    }

    @Test
    public void getTest() throws ValidationException {
        Subscription subscription1 = new Subscription((float) 10, 1L, 1L);
        Subscription subscription2 = new Subscription((float) 20, 1L, 2L);
        List<Subscription> subscriptions = new ArrayList<Subscription>();
        subscriptions.add(subscription1);
        subscriptions.add(subscription2);
        User user = new User("Ivanov@mail.ru", "Ivan", subscriptions);

        given(userDao.findOne(1L)).willReturn(user);

        UserDto actualUserDto = userService.getUser(1L);

        SubscriptionDto subscriptionDto1 = new SubscriptionDto(1L, (float) 10, 1L);
        SubscriptionDto subscriptionDto2 = new SubscriptionDto(1L, (float) 20, 2L);
        List <SubscriptionDto> subscriptionDtos = new ArrayList<>();
        subscriptionDtos.add(subscriptionDto1);
        subscriptionDtos.add(subscriptionDto2);
        UserDto expectedUserDto = new UserDto(1L, "Ivanov@mail.ru", "Ivan", subscriptionDtos);

        assertThat(actualUserDto).isEqualTo(expectedUserDto);
    }
}
