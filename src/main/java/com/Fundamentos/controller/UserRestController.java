package com.Fundamentos.controller;

import com.Fundamentos.caseuse.GetUser;
import com.Fundamentos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import  org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {
    /*
     Create, Get, delete, update
     */

    private GetUser getUser;

    @Autowired
    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(getUser.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return new ResponseEntity<>(getUser.getUserById(userId).get(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<User> newUser(@RequestBody User user) {
        return new ResponseEntity<User>(getUser.saveUser(user), HttpStatus.OK);
    }

   @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        getUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
   }

   @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long userId){
      return new ResponseEntity<>(getUser.updateUser(user , userId),HttpStatus.OK);
   }

}