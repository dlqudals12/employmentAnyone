package com.employmentAnyone.data.repository.employee;

import com.employmentAnyone.data.model.entity.employee.EmploymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentCategoryRepository extends JpaRepository<EmploymentCategory, Long> {
}
