package com.jobportal.companies.repos;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.companies.entities.Company;

@Repository
public interface CompanyRepo extends ElasticsearchRepository<Company, Integer>{
    
}
