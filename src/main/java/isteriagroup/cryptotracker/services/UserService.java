package isteriagroup.cryptotracker.services;


import isteriagroup.cryptotracker.daos.UserDao;
import isteriagroup.cryptotracker.dtos.UserDto;
import isteriagroup.cryptotracker.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public UserDto getUser(Long userId){
        User user = userDao.findOne(userId);
        return buildUserDtoFromUser(user);
    }

    private UserDto buildUserDtoFromUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());

        return userDto;
    }

    public UserDto getUserByEmail(String userEmail){
        User user = userDao.findByEmail(userEmail);
        return buildUserDtoFromUser(user);
    }
}