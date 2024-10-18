package com.employmentAnyone.data.repository.company;

import com.employmentAnyone.data.model.entity.user.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByName(String companyName);
}
