package com.assessment.project.customermanagementsystem.repo;

import com.assessment.project.customermanagementsystem.entity.MobileNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileNumberRepo extends JpaRepository<MobileNumber,Long> {
    List<MobileNumber> findAllByCustomer_CustomerId(Long customerId);
}
