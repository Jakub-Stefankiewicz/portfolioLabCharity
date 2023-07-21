package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    //model attribute
    @RequestMapping("/form")
    public String donationForm(Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("donation", new Donation());
        model.addAttribute("institutions", institutionService.findAll());
        return "form";
    }

    @PostMapping("/form")
    public String saveDonation(Donation donation){
        donationService.save(donation);
        return "redirect:/form";
    }

}
