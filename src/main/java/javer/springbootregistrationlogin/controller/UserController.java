package javer.springbootregistrationlogin.controller;

import javer.springbootregistrationlogin.model.User;
import javer.springbootregistrationlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "sign_up_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user) {
        userRepository.save(user);
        return "register_success";
    }
}
