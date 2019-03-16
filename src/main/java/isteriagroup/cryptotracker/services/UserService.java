package isteriagroup.cryptotracker.services;

import isteriagroup.cryptotracker.common.utils.ValidationException;
import isteriagroup.cryptotracker.common.utils.ValidationUtils;


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

    public UserDto getUser(Long userId) throws ValidationException {
        ValidationUtils.validateIsNotNull(userId, "No user id provided");

        User user = userDao.findOne(userId);
        ValidationUtils.validateIsNotNull(user, "No user with id " + userId);

        return buildUserDtoFromUser(user);
    }

    private UserDto buildUserDtoFromUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());

        return userDto;
    }

    public UserDto getUserByEmail(String userEmail) throws ValidationException{
        ValidationUtils.validateIsNotNull(userEmail, "No user email provided");

        User user = userDao.findByEmail(userEmail);
        ValidationUtils.validateIsNotNull(user, "No user with email" + userEmail);

        return buildUserDtoFromUser(user);
    }
}