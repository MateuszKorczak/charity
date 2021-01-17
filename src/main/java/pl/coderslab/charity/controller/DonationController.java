package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.services.interfaces.CategoryService;
import pl.coderslab.charity.services.interfaces.DonationService;
import pl.coderslab.charity.services.interfaces.InstitutionService;

import javax.validation.Valid;


@Controller
public class DonationController {

    private final InstitutionService institutionService;
    private final CategoryService categoryService;
    private final DonationService donationService;

    public DonationController(InstitutionService institutionService, CategoryService categoryService, DonationService donationService) {
        this.institutionService = institutionService;
        this.categoryService = categoryService;
        this.donationService = donationService;
    }

    @RequestMapping("/form")
    public String form(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("institutions", institutionService.findAllInstitutions());
        model.addAttribute("donation", new Donation());
        return "donationForm";
    }

    @PostMapping("/form")
    public String proceedForm(@Valid Donation donation, BindingResult result) {
//        napisz validację przed zapisaniem do bazy
// sprawdź instytucje/ kategorie

        if (!result.hasErrors()) {
            donationService.saveDonation(donation);
            return "donationForm-conf";
        }
        return "donationForm";
    }


}