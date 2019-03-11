package isteriagroup.cryptotracker.services;


import isteriagroup.cryptotracker.daos.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }
}
