package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/admin")
public class AdminController {
    @GetMapping("/homepage")
    public String homepage(){
        return "admin/homepage";
    }
}
