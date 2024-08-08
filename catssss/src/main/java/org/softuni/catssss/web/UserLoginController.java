package org.softuni.catssss.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {



    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

//    @PostMapping("/users/login-error")
//    public String onFailure(
//            @ModelAttribute("email") String email,
//            Model model) {
//
//        model.addAttribute("email", email);
//        model.addAttribute("bad_credentials", "true");
//
//        return "auth-login";
//    }




}
