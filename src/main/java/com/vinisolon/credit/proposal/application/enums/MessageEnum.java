package com.vinisolon.credit.proposal.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageEnum {

    DEFAULT_SUCCESS_MESSAGE("Success."),
    DEFAULT_ERROR_MESSAGE("Unexpected error."),
    INVALID_PROPOSAL_STATUS_CODE("Invalid proposal status code."),
    INVALID_DOCUMENT_TYPE_CODE("Invalid document type code."),
    CUSTOMER_NOT_FOUND("Customer not found."),
    DOCUMENT_ALREADY_REGISTERED("Customer document already registered.");

    private final String message;

}
