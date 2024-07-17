package com.vinisolon.credit.proposal.application.repositories;

import com.vinisolon.credit.proposal.application.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
