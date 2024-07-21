package com.vinisolon.credit.proposal.application.mappers;

import com.vinisolon.credit.proposal.application.dtos.requests.CreateInitialProposalRequest;
import com.vinisolon.credit.proposal.application.dtos.requests.CreateNewProposalRequest;
import com.vinisolon.credit.proposal.application.dtos.responses.ConsultProposalResponse;
import com.vinisolon.credit.proposal.application.dtos.responses.CreateProposalResponse;
import com.vinisolon.credit.proposal.application.entities.Customer;
import com.vinisolon.credit.proposal.application.entities.Proposal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProposalMapper {

    Proposal fromCreateInitialProposalRequestToEntity(CreateInitialProposalRequest request, String status);

    CreateProposalResponse fromEntityToProposalResponse(Proposal proposal);

    Proposal fromCreateNewProposalRequestToEntity(CreateNewProposalRequest request, Customer customer, String status);

    @Mapping(target = "customerId", source = "proposal.customer.customerId")
    ConsultProposalResponse fromProposalToConsultProposalResponse(Proposal proposal);

}
