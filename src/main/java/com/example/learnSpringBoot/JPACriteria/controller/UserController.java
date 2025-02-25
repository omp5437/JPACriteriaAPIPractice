package com.example.learnSpringBoot.JPACriteria.controller;

import com.example.learnSpringBoot.JPACriteria.dto.UserDto;
import com.example.learnSpringBoot.JPACriteria.entity.UserDetail;
import com.example.learnSpringBoot.JPACriteria.exceptions.ResourceNotFoundException;
import com.example.learnSpringBoot.JPACriteria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDetail user){
       UserDto newUser=userService.addUser(user);

       return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getSingleUser( @PathVariable("id") int id){
        UserDto user=userService.getUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/get-users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> user=userService.getAllUsers();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserDto> getUpdatedUser(@PathVariable("id") int id, @RequestBody UserDetail user){
            return new ResponseEntity<>(userService.updateUser(id,user),HttpStatus.OK);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        String response=userService.deleteUser(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
