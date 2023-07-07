package com.assessment.project.customermanagementsystem.repo;

import com.assessment.project.customermanagementsystem.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {

}
