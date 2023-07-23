package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.entity.UserToRegister;
import pl.coderslab.charity.service.UserService;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
private final UserService userService;
    @GetMapping("/register")
    public String createUser(Model model){
        model.addAttribute("userToRegister", new UserToRegister());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@Valid UserToRegister userToRegister, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "register";
        }
        User user=new User();
        userService.save(user, userToRegister);
     return "redirect:/" ;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
