package com.example.pp_3_1_1.contoller;

import com.example.pp_3_1_1.model.User;
import com.example.pp_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users/index";
    }

    @GetMapping("/add")
    public String newUser(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "/users/add";
    }

    @GetMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("/users/edit_user");
        User user = userService.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }

    @PostMapping( "/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUserForm(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
