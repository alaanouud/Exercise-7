package com.example.day7.service;

import com.example.day7.Model.User;
import com.example.day7.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Userservice {

    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public boolean updateUser(Integer id,User user){
        User olduser=userRepository.getById(id);
        if(olduser==null){
            return false;
        }

        olduser.setName(user.getName());
        olduser.setUsername(user.getUsername());
        olduser.setPassword(user.getPassword());
        olduser.setEmail(user.getEmail());
        olduser.setRole(user.getRole());
        olduser.setAge(user.getAge());

        userRepository.save(olduser);
        return true;
    }
    public boolean deleteUser(Integer id){
        User user=userRepository.getById(id);
        if(user==null){
            return false;

        }
        userRepository.delete(user);
        return true;
    }








}
