package com.vinisolon.credit.proposal.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProposalStatusEnum {

    NEW((short) 1),
    INTEGRATED((short) 2),
    APPROVED((short) 3),
    REPROVED((short) 4);

    private final short code;

}
