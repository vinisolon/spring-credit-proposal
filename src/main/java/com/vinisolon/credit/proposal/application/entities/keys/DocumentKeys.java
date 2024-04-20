package com.vinisolon.credit.proposal.application.entities.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DocumentKeys {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "document_number", unique = true)
    private String documentNumber;

}
