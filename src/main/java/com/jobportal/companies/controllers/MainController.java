package com.jobportal.companies.controllers;

import com.jobportal.companies.entities.Company;
import com.jobportal.companies.services.CompanyService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class MainController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public String getAllCompanies(Model model) {
        Iterable<Company> companies = companyService.getCompanies();
        model.addAttribute("companies", companies);
        return "HomeDashboard";
    }

    @PostMapping("/insert")
public String insertCompany(@ModelAttribute("company") Company company) {
    Company result = companyService.saveCompany(company);
    return "redirect:/companies"; // Assuming you have a mapping to display all companies
}

    
    @PostMapping("/insertAll")
    public ResponseEntity<Void> insertAllCompanies(@RequestBody List<Company> companies) {
    Iterable<Company> existingCompanies = companyService.getCompanies();

    Set<String> existingCompanyNames = new HashSet<>();
    existingCompanies.forEach(company -> existingCompanyNames.add(company.getName().toLowerCase()));

    List<Company> newCompanies = companies.stream()
            .filter(company -> !existingCompanyNames.contains(company.getName().toLowerCase()))
            .collect(Collectors.toList());

    companyService.saveAllCompanies(newCompanies);
    
    return ResponseEntity.ok().build();
}
    
}
