package com.assessment.project.customermanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "customer_dob", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "customer_nic", nullable = false,unique = true)
    private String customerNIC;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Customer familyMember;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "familyMember")
    @JsonIgnore 
    private List<Customer> familyMembers;    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<MobileNumber> mobileNumbers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonManagedReference
    private List<Address> addresses;

    @PrePersist
    private void ensureFamilyMemberSet() {
        if (this.familyMember == null ) {
            familyMember = this;
        }
    }

}
