package com.vinisolon.credit.proposal.application.services;

import com.vinisolon.credit.proposal.application.dtos.requests.CreateCustomerRequest;
import com.vinisolon.credit.proposal.application.dtos.requests.CreateInitialProposalRequest;
import com.vinisolon.credit.proposal.application.dtos.requests.CreateNewProposalRequest;
import com.vinisolon.credit.proposal.application.dtos.responses.ProposalResponse;
import com.vinisolon.credit.proposal.application.entities.Customer;
import com.vinisolon.credit.proposal.application.enums.MessageEnum;
import com.vinisolon.credit.proposal.application.enums.ProposalStatusEnum;
import com.vinisolon.credit.proposal.application.exceptions.BusinessException;
import com.vinisolon.credit.proposal.application.mappers.ProposalMapper;
import com.vinisolon.credit.proposal.application.repositories.CustomerRepository;
import com.vinisolon.credit.proposal.application.repositories.DocumentRepository;
import com.vinisolon.credit.proposal.application.repositories.ProposalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final ProposalMapper proposalMapper;
    private final CustomerRepository customerRepository;
    private final DocumentRepository documentRepository;

    public ProposalResponse createInitialProposal(CreateInitialProposalRequest request) {
        validateDocuments(request.getCustomer());

        var proposal = proposalMapper.fromCreateInitialProposalRequestToEntity(request, ProposalStatusEnum.NEW.getValue());

        proposal = proposalRepository.save(proposal);

        return proposalMapper.fromEntityToProposalResponse(proposal);
    }

    public ProposalResponse createNewProposal(CreateNewProposalRequest request) {
        var customer = getCustomerById(request.getCustomerId());

        var proposal = proposalMapper.FromCreateNewProposalRequestToEntity(request, customer, ProposalStatusEnum.NEW.getValue());

        proposal = proposalRepository.save(proposal);

        return proposalMapper.fromEntityToProposalResponse(proposal);
    }

    private void validateDocuments(CreateCustomerRequest customer) {
        customer.getDocuments()
                .forEach(document -> documentRepository.findByDocumentNumber(document.getDocumentNumber())
                        .ifPresent(finded -> {
                            throw new BusinessException(MessageEnum.DOCUMENT_ALREADY_REGISTERED.getMessage());
                        })
                );
    }

    private Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new BusinessException(MessageEnum.CUSTOMER_NOT_FOUND.getMessage()));
    }

}
