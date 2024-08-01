package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/user_list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user_list";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/added")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users/user_list";
    }

    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users/user_list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users/user_list";
    }
}
