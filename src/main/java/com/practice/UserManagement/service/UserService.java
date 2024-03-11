package com.practice.UserManagement.service;


import com.practice.UserManagement.Repository.UserRepository;
import com.practice.UserManagement.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setMobile(user.getMobile());
        newUser.setAddress(user.getAddress());

        newUser = userRepository.save(newUser);


        return newUser;

    }


    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void updateByName(Long id,String name) {
        User user = getUserById(id);
        user.setName(name);
        userRepository.save(user);

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
