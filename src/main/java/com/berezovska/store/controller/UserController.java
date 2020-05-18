package com.berezovska.store.controller;

import com.berezovska.store.controller.exception.ErrorMessage;
import com.berezovska.store.controller.exception.UserAlreadyExistsException;
import com.berezovska.store.controller.exception.UserNotExistsException;
import com.berezovska.store.model.User;
import com.berezovska.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView registerUser(@ModelAttribute("userForm") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/user/registration");
        }

        try {
            userService.save(user);
            return new ModelAndView("redirect:/login");
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return new ModelAndView("redirect:/user/registration");
        }

    }

    @GetMapping(path = "/createUser")
    public String getCreateUserView(Model model) {
        return "create_user";
    }


    @PostMapping(path = "/createUser")
    public String createUser(@ModelAttribute("userForm") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create_user";
        }
        try {
            userService.save(user);
            model.addAttribute("email", user.getEmail());
            return "user_created";
        } catch (UserAlreadyExistsException e) {

            model.addAttribute("errors", List.of(new ErrorMessage("", e.getMessage())));
            return "create_user";
        }
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable UUID id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("user") User user) {
        userService.update(user);
        return new ModelAndView("redirect:/user/showUsers");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable java.util.UUID id) {
        userService.delete(id);
        return new ModelAndView("redirect:/user/showUsers");
    }

    @ModelAttribute("userForm")
    public User getDefaultUser() {
        return new User();
    }
}