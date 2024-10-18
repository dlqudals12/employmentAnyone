package com.employmentAnyone.data.repository.employee;

import com.employmentAnyone.data.model.entity.employee.EmploymentCenter;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmploymentCenterRepository extends JpaRepository<EmploymentCenter, Long>, EmploymentCenterRepositoryCustom {
    Optional<EmploymentCenter> findByTitle(@NotNull String title);
}
