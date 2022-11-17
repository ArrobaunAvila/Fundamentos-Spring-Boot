package com.Fundamentos.service;

import com.Fundamentos.entity.User;
import com.Fundamentos.repository.UserRepository;
import lombok.*;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@Getter
@Setter
@Service
public class UserService {

    private final Log LOG = LogFactory.getLog(UserService.class);


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //@Transactional
    public void saveTransactional(List<User> users) {
        users.stream()
                .peek(user -> LOG.info("Usuario Insertado: " + user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.delete(new User(id));
    }

    public User updateUser(User user, Long id) {
        return userRepository.findById(id)
                .map(user -> {
                            user.setName(user.getName());
                            user.setBirthday(user.getBirthday());
                            user.setEmail(user.getEmail());
                            user.setAddress(user.getAddress());
                            return userRepository.save(user);
                        }
                );

    }

}
