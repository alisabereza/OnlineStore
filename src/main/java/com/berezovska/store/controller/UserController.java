package com.berezovska.store.controller;

import com.berezovska.store.controller.exception.UserAlreadyExistsException;
import com.berezovska.store.controller.exception.UserNotExistsException;
import com.berezovska.store.model.User;
import com.berezovska.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUsers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/showUsers")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("users", userList);
        return "show_users";
    }

    @GetMapping(path = "/get")
    public String getUserById(@RequestParam("id") UUID id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user_details";
    }

    @GetMapping(path = "/findPage")
    public String showFindUserPage() {
        return "find_user";
    }

    @GetMapping(path = "/find")
    public String findUser(@RequestParam("email") String email, Model model) {
        User user = null;
        try {
            user = userService.getByEmail(email);
        } catch (UserNotExistsException e) {
            model.addAttribute("error", e.getMessage());
            return "find_user";
        }
        model.addAttribute("user", user);
        return "user_details";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {

        return "registration";
    }

    @PostMapping(path = "/registration")
    public String registerUser(@ModelAttribute("userForm") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }

        try {
            userService.save(user);
        } catch (UserAlreadyExistsException ex) {
            model.addAttribute("message", "An account for that username already exists.");
            return "registration";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "login";
    }

    @ModelAttribute("userForm")
    public User getDefaultUser() {
        return new User();
    }
}