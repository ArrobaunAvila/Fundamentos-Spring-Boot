package com.Fundamentos.caseuse;

import com.Fundamentos.service.UserService;
import com.Fundamentos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class GetUserImplement implements GetUser{

    private UserService userService;

    public GetUserImplement( UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userService.getUserById(id);

    }

    @Override
    public User saveUser(User user) {
        return userService.save(user);
    }

    @Override
    public void remove(Long id) {
      userService.deleteUser(id);
    }

    @Override
    public User updateUser(User user, Long id) {
        userService.updateUser(user, id);
    }


}
