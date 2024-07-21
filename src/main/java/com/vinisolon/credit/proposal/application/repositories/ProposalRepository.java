package com.vinisolon.credit.proposal.application.repositories;

import com.vinisolon.credit.proposal.application.entities.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    List<Proposal> findAllByCustomer_CustomerId(Long customerId);

}
