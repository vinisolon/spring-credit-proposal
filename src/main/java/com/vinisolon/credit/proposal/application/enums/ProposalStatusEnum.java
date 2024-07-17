package com.vinisolon.credit.proposal.application.enums;

import com.vinisolon.credit.proposal.application.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum ProposalStatusEnum {

    NEW("NEW"),
    INTEGRATED("INTEGRATED"),
    APPROVED("APPROVED"),
    REPROVED("REPROVED");

    private final String value;

    public static ProposalStatusEnum getByValueIfExists(String value) {
        return Arrays.stream(ProposalStatusEnum.values())
                .filter(enm -> Objects.equals(value, enm.getValue()))
                .findAny()
                .orElseThrow(() -> new BusinessException(MessageEnum.INVALID_PROPOSAL_STATUS_CODE.getMessage()));
    }

}
