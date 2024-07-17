package com.vinisolon.credit.proposal.application.mappers;

import com.vinisolon.credit.proposal.application.dtos.requests.CreateInitialProposalRequest;
import com.vinisolon.credit.proposal.application.dtos.requests.CreateNewProposalRequest;
import com.vinisolon.credit.proposal.application.dtos.responses.ProposalResponse;
import com.vinisolon.credit.proposal.application.entities.Customer;
import com.vinisolon.credit.proposal.application.entities.Proposal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProposalMapper {

    Proposal fromCreateInitialProposalRequestToEntity(CreateInitialProposalRequest request, String status);

    ProposalResponse fromEntityToProposalResponse(Proposal proposal);

    Proposal FromCreateNewProposalRequestToEntity(CreateNewProposalRequest request, Customer customer, String status);

}
