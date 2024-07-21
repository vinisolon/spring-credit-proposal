package com.vinisolon.credit.proposal.application.services;

import com.vinisolon.credit.proposal.application.dtos.requests.CreateCustomerRequest;
import com.vinisolon.credit.proposal.application.dtos.requests.CreateInitialProposalRequest;
import com.vinisolon.credit.proposal.application.dtos.requests.CreateNewProposalRequest;
import com.vinisolon.credit.proposal.application.dtos.responses.ConsultProposalResponse;
import com.vinisolon.credit.proposal.application.dtos.responses.CreateProposalResponse;
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

import java.util.List;

@Service
@AllArgsConstructor
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final ProposalMapper proposalMapper;
    private final CustomerRepository customerRepository;
    private final DocumentRepository documentRepository;

    public List<ConsultProposalResponse> getProposals() {
        return proposalRepository.findAll()
                .stream()
                .map(proposalMapper::fromProposalToConsultProposalResponse)
                .toList();
    }

    public CreateProposalResponse createInitialProposal(CreateInitialProposalRequest request) {
        validateDocumentsExistence(request.getCustomer());

        var proposal = proposalMapper.fromCreateInitialProposalRequestToEntity(request, ProposalStatusEnum.NEW.getValue());

        proposal = proposalRepository.save(proposal);

        return proposalMapper.fromEntityToProposalResponse(proposal);
    }

    public CreateProposalResponse createNewProposal(CreateNewProposalRequest request) {
        var customer = getCustomerIfExists(request.getCustomerId());

        var proposal = proposalMapper.fromCreateNewProposalRequestToEntity(request, customer, ProposalStatusEnum.NEW.getValue());

        proposal = proposalRepository.save(proposal);

        return proposalMapper.fromEntityToProposalResponse(proposal);
    }

    private void validateDocumentsExistence(CreateCustomerRequest customer) {
        customer.getDocuments()
                .forEach(document -> documentRepository.findByDocumentNumber(document.getDocumentNumber())
                        .ifPresent(finded -> {
                            throw new BusinessException(MessageEnum.DOCUMENT_ALREADY_REGISTERED.getMessage());
                        })
                );
    }

    private Customer getCustomerIfExists(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new BusinessException(MessageEnum.CUSTOMER_NOT_FOUND.getMessage()));
    }

}
