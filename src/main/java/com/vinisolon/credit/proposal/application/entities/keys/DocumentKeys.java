package com.vinisolon.credit.proposal.application.entities.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DocumentKeys {

    private String documentNumber;

    private Long customerId;

}
