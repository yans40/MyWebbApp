package com.mycompany.mywebbapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> ListAll(){
        return (List<User>) userRepository.findAll();
    }

    public void save(User user) {

        userRepository.save(user);
    }
}
