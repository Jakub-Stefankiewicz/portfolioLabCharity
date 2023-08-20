package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/admin")
public class InstitutionController {
    private final InstitutionService institutionService;

    @GetMapping("/institutions")
    public String institutions(Model model) {
        model.addAttribute("institutions", institutionService.findAll());
        return "admin/institutions";
    }

    @GetMapping("/institutions/add")
    public String addInstitution(Model model) {
        model.addAttribute("institution", new Institution());
        return "admin/add-institution";
    }

    @PostMapping("/institutions/add")
    public String saveInstitution(@Valid Institution institution, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/add-institution";
        }
        institutionService.save(institution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/institutions/edit/{id}")
    public String editInstitution(@PathVariable Long id, Model model) {
        model.addAttribute("institutionToEdit", model.addAttribute(institutionService.findById(id)));
        return "admin/edit-institution";
    }

    @PostMapping("/institutions/edit/{id}")
    public String saveEditedInstitution(@Valid Institution editedInstitution, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/edit-institution";
        }
        institutionService.save(editedInstitution);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/institutions/delete/{id}")
    public String deleteInstitution(@PathVariable Long id) {
        institutionService.delete(institutionService.findById(id));
        return "redirect:/admin/institutions";
    }

}
