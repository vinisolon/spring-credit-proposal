package com.vinisolon.credit.proposal.application.enums;

import com.vinisolon.credit.proposal.application.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum DocumentTypeEnum {

    CPF("CPF"),
    CNPJ("CNPJ");

    private final String value;

    public static DocumentTypeEnum getByValueIfExists(String value) {
        return Arrays.stream(DocumentTypeEnum.values())
                .filter(enm -> Objects.equals(value, enm.getValue()))
                .findAny()
                .orElseThrow(() -> new BusinessException(MessageEnum.INVALID_DOCUMENT_TYPE_CODE.getMessage()));
    }

}
