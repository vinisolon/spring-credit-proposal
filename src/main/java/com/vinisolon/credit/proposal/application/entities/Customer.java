package com.vinisolon.credit.proposal.application.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "full_name")
    private String fullName;

    private BigDecimal income;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Document> documents = new HashSet<>();

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Proposal> proposals = new HashSet<>();

}
