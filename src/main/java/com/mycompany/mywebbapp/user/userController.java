package com.mycompany.mywebbapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> listUsers = userService.ListAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user",new User());
                return "user_form";
    }
}
