package com.vinisolon.credit.proposal.application.entities;

import com.vinisolon.credit.proposal.application.enums.DocumentTypeEnum;
import com.vinisolon.credit.proposal.application.entities.keys.DocumentKeys;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    @EmbeddedId
    private DocumentKeys keys = new DocumentKeys();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false, insertable = false, updatable = false)
    private Customer customer;

    private DocumentTypeEnum type;

}
