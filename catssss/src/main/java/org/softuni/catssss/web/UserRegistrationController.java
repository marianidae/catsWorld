package org.softuni.catssss.web;

import org.softuni.catssss.model.dto.UserRegistrationDTO;
import org.softuni.catssss.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserRegistrationController {

    private final UserService userService;


    public UserRegistrationController(
            UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistrationDTO) {
        userService.registerUser(userRegistrationDTO);
        return "redirect:/";
    }


}
