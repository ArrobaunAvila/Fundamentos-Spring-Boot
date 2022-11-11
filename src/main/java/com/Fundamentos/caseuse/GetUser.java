package com.Fundamentos.caseuse;

import com.Fundamentos.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface GetUser {

    List<User> getAll();

    Optional<User> getUserById(Long id);
}
