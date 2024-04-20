package com.vinisolon.credit.proposal.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentTypeEnum {

    CPF((short) 1),
    CNPJ((short) 2);

    private final short code;

}
