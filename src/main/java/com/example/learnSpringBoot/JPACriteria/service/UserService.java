package com.example.learnSpringBoot.JPACriteria.service;

import com.example.learnSpringBoot.JPACriteria.dto.UserDto;
import com.example.learnSpringBoot.JPACriteria.entity.UserDetail;
import com.example.learnSpringBoot.JPACriteria.exceptions.ResourceNotFoundException;


import java.util.List;


public interface UserService {

    public UserDto addUser(UserDetail user);

    public UserDto updateUser(int id ,UserDetail user) throws ResourceNotFoundException;

    public UserDto getUser(int id);

    public List<UserDto> getAllUsers();

    public String deleteUser(int id);

}
