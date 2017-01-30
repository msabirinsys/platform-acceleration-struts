package org.superbiz.struts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.superbiz.struts.User;
import org.superbiz.struts.repositories.UserRepository;

/**
 * Created by msabir on 1/30/17.
 */
@Controller
public class UsersController {
    private UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @GetMapping("/addUser")
    public String addUserForm() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(long id, String firstName, String lastName) {
        userRepository.save(new User(id, firstName, lastName));
        return "addedUser";
    }

    @GetMapping("/findUser")
    public String findUserForm() {
        return "findUserForm";
    }

    @PostMapping("/findUser")
    public String findUser(@RequestParam long id, Model model) {
        User user = userRepository.findOne(id);

        if (user == null) {
            model.addAttribute("errorMessage", "User not found");
            return "findUserForm";
        }

        model.addAttribute("user", user);
        return "displayUser";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "displayUsers";
    }
}