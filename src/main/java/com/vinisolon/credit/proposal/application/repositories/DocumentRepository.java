package com.vinisolon.credit.proposal.application.repositories;

import com.vinisolon.credit.proposal.application.entities.Document;
import com.vinisolon.credit.proposal.application.entities.keys.DocumentKeys;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, DocumentKeys> {

    Optional<Document> findByDocumentNumber(String documentNumber);

}
