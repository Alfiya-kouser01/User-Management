package com.codedecode.userinfo.service;

import com.codedecode.userinfo.DTO.UserDTO;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.repository.UserRepository;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDTO addUser(UserDTO userDTO) {
       User savedUser =  userRepository.save(UserMapper.INSTANCE.mapUserDTOTOUser(userDTO));
       return UserMapper.INSTANCE.mapUserTOUserDTO(savedUser);

    }


    public ResponseEntity<UserDTO> fetchUserById(Integer userId) {
       Optional<User>  fetchUser = userRepository.findById(userId);
        if(fetchUser.isPresent()) {
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserTOUserDTO(fetchUser.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
