package com.vinisolon.credit.proposal.application.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinisolon.credit.proposal.application.enums.ProposalStatusEnum;
import com.vinisolon.credit.proposal.application.util.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProposalResponse {

    private Long proposalId;

    private BigDecimal requestedAmount;

    private Short paymentTerm;

    private ProposalStatusEnum status;

    @JsonFormat(pattern = DateUtils.JSON_DATE_HOUR_PATTERN, timezone = "UTC")
    private Instant createdAt;

    @JsonFormat(pattern = DateUtils.JSON_DATE_HOUR_PATTERN, timezone = "UTC")
    private Instant updatedAt;

    private CreateCustomerResponse customer;

}
