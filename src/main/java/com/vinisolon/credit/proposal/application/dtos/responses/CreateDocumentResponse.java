package com.vinisolon.credit.proposal.application.dtos.responses;

import com.vinisolon.credit.proposal.application.enums.DocumentTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDocumentResponse {

    private String documentNumber;

    private DocumentTypeEnum documentType;

}
