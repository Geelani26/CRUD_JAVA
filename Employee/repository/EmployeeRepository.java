package com.example.Employee.repository;

import com.example.Employee.models.EmployeeDetails;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> , JpaSpecificationExecutor<EmployeeDetails> {



    Optional<EmployeeDetails> findByEmployeeId(@NotNull(message = "Enter Employee ID") @Digits(integer = 4, fraction = 0, message = "Invalid") Integer employeeId);

    Optional<EmployeeDetails> findByEmployeeIdAndIdNot(@NotNull(message = "Enter Employee ID") @Digits(integer = 4, fraction = 0, message = "Invalid") Integer employeeId, Integer id);
}
