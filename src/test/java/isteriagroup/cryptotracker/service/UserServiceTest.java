package isteriagroup.cryptotracker.service;

import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.common.utils.ValidationUtils;
import isteriagroup.cryptotracker.daos.UserDao;
import isteriagroup.cryptotracker.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import isteriagroup.cryptotracker.common.utils.ValidationException;

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
}
