package com.vinisolon.credit.proposal.application.resources;

import com.vinisolon.credit.proposal.application.dtos.requests.CreateInitialProposalRequest;
import com.vinisolon.credit.proposal.application.dtos.requests.CreateNewProposalRequest;
import com.vinisolon.credit.proposal.application.services.ProposalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/proposals")
public class ProposalController {

    private final ProposalService proposalService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createInitialProposal(@RequestBody CreateInitialProposalRequest request) {
        log.info("Create initial proposal request {}", request);
        var response = proposalService.createInitialProposal(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{customerId}")
    @Transactional
    public ResponseEntity<?> createNewProposal(@PathVariable("customerId") Long customerId, @RequestBody CreateNewProposalRequest request) {
        request.setCustomerId(customerId);
        log.info("Create new proposal request {}", request);
        var response = proposalService.createNewProposal(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
