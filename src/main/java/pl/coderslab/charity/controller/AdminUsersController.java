package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.UserCharity;
import pl.coderslab.charity.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/admin")
public class AdminUsersController {
    private final UserService userService;

    @GetMapping("/users")
    public String usersList(Model model){
        model.addAttribute("users", userService.findAllUsers());
        return "admin/users";
    }

    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("userToEdit", userService.findById(id));
        return "admin/edit-user";
    }

    @PostMapping("/user/edit/{id}")
    public String saveEditedUser(@ModelAttribute("userToEdit") @Valid UserCharity userCharity, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/edit-user";
        }
        userService.save(userCharity);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(userService.findById(id));
        return "redirect:/admin/users";
    }
}
