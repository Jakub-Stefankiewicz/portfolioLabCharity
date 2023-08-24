package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.UserCharity;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserService;


@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @ModelAttribute("sessionUser")
    public UserCharity sessionUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.findByUsername(authentication.getName());
    }

    @GetMapping("/homepage")
    public String homepage() {
        return "admin/homepage";
    }


    @GetMapping("/admins")
    public String adminsList(Model model) {
        model.addAttribute("admins", userService.adminsList());
        model.addAttribute("users", userService.findAllUsers());
        return "admin/admins";
    }

    @GetMapping("/admins/edit/{id}")
    public String editAdmin(@PathVariable Long id, Model model) {
        model.addAttribute("adminToEdit", userService.findById(id));
        return "admin/edit-admin";
    }

    @PostMapping("/admins/edit/{id}")
    public String saveEditedAdmin(@ModelAttribute("adminToEdit") @Valid UserCharity adminToEdit, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/edit-admin";
        }
        userService.save(adminToEdit);
        return "redirect:/admin/admins";
    }
    @GetMapping("/admins/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        userService.deleteAdmin(userService.findById(id));
        return "redirect:/admin/admins";
    }

    @PostMapping("/admins")
    public String deleteAdmin(UserCharity userCharity) {
        userService.save(userCharity);
        return "redirect:/admin/admins";
    }

}
