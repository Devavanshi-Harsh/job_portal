package com.jobportal.companies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.companies.entities.Company;
import com.jobportal.companies.repos.CompanyRepo;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    public Iterable<Company> getCompanies(){
        return companyRepo.findAll();
    }

    public Company saveCompany(Company company){
        return companyRepo.save(company);
    }
    public void saveAllCompanies(List<Company> companies){
        companyRepo.saveAll(companies);
    }
}
