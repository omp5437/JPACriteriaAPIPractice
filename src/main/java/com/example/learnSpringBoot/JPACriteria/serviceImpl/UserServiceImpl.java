package com.example.learnSpringBoot.JPACriteria.serviceImpl;

import com.example.learnSpringBoot.JPACriteria.dto.UserDto;
import com.example.learnSpringBoot.JPACriteria.entity.UserDetail;
import com.example.learnSpringBoot.JPACriteria.exceptions.ResourceNotFoundException;
import com.example.learnSpringBoot.JPACriteria.repository.UserRepository;
import com.example.learnSpringBoot.JPACriteria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDto addUser(UserDetail user) {
        UserDetail savedUser=userRepo.save(user);
        return savedUser.toDto();
    }

    @Override
    public UserDto updateUser(int id,UserDetail user)  {

            UserDetail updateUserDetail = userRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User", "userId", String.valueOf(id)));

            if (user.getFirstName() != null) {
                updateUserDetail.setFirstName(user.getFirstName());
            }

            if (user.getLastName() != null) {
                updateUserDetail.setLastName(user.getLastName());
            }

            if (user.getEmail() != null) {
                updateUserDetail.setEmail(user.getEmail());
            }

            if (user.getContact() != 0) {
                updateUserDetail.setContact(user.getContact());
            }
            return userRepo.save(updateUserDetail).toDto();



    }

    @Override
    public UserDto getUser(int id) {
       UserDetail user= userRepo.findById(id).get();
       return user.toDto();
    }

    @Override
    public List<UserDto> getAllUsers() {
        Pageable pageable= PageRequest.of(1,1);
       Page<UserDetail> page=  userRepo.findAll(pageable);
       List<UserDetail> users=page.getContent();
       return users.stream().map(a->a.toDto()).collect(Collectors.toList());
    }

    @Override
    public String deleteUser(int id) {
         UserDetail userDetail=userRepo.findById(id).orElse(null);
         if(userDetail!=null){
             userRepo.findById(id).orElse(null);//first level cache
             userRepo.deleteById(id);
             return "User deleted successfully!";
         }

         return "No user found!";
    }
}
