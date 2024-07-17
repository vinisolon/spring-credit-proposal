package com.vinisolon.credit.proposal.application.entities;

import com.vinisolon.credit.proposal.application.entities.keys.DocumentKeys;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(DocumentKeys.class)
public class Document {

    @Id
    @Column(name = "document_number", unique = true)
    private String documentNumber;

    @Id
    @Column(name = "customer_id")
    private Long customerId;

    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @Column(name = "document_type")
    private String documentType;

}
