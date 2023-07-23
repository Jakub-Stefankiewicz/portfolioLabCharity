package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @ModelAttribute("categories")
    public List<Category> categoryList(){
        return categoryService.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutionList(){
        return institutionService.findAll();
    }


    @RequestMapping("/form")
    public String donationForm(Model model){
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/form")
    public String saveDonation(@Valid Donation donation, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        donationService.save(donation);
        return "redirect:/form";
    }

}
