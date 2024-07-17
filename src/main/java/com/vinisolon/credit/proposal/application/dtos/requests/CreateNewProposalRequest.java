package com.vinisolon.credit.proposal.application.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewProposalRequest {

    private Long customerId;

    private BigDecimal requestedAmount;

    private Short paymentTerm;

}
