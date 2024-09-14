package com.codedecode.userinfo.controller;


import com.codedecode.userinfo.DTO.UserDTO;
import com.codedecode.userinfo.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    // saving user into dataBase it can be during signup
    // get the data of the user from the database


    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
       UserDTO savedUser =  userService.addUser(userDTO);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("fetchUserById/{userId}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable Integer userId){
          return userService.fetchUserById(userId);
    }

}
