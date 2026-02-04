package com.l2t.cbook.service;

import com.l2t.cbook.domain.ContactDetails;

import java.util.List;
import java.util.UUID;

public interface ContactService {

    List<ContactDetails> getAllContacts();
    ContactDetails getContactById(UUID id);
    ContactDetails addContact(ContactDetails contact);
    ContactDetails updateContact(ContactDetails contact);
    boolean deleteContact(UUID id);
    List<ContactDetails> searchContacts(String name);

}
