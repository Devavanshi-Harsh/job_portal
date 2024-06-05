package com.jobportal.companies.entities;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "company_data")
public class Company {

    private int id;
    private String name;
    private String description;
    private String url;
}
