package com.l2t.cbook.repo;

import com.l2t.cbook.domain.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContactRepo extends JpaRepository<ContactDetails, UUID> {
    List<ContactDetails> findByNameContaining(String name);
}
