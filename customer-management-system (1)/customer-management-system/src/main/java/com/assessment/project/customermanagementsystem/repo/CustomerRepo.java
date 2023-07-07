package com.assessment.project.customermanagementsystem.repo;

import com.assessment.project.customermanagementsystem.entity.Customer;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
