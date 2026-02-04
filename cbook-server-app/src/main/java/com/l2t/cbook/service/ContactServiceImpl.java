package com.l2t.cbook.service;

import com.l2t.cbook.repo.ContactRepo;
import com.l2t.cbook.domain.ContactDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepo contactRepo;

    @Override
    public List<ContactDetails> getAllContacts() {
        List<ContactDetails> contactDetails =  contactRepo.findAll();
        log.info("Contact count is :{}",contactDetails.size());
        return contactDetails;
    }

    @Override
    public ContactDetails getContactById(UUID id) {
        return contactRepo.findById(id).orElse(null);
    }

    @Override
    public ContactDetails addContact(ContactDetails contact) {
        log.info("Adding contact with name : {}, email : {}, mobile : {}",
                contact.getName(), contact.getEmail(), contact.getMobile());
        ContactDetails savedContact = contactRepo.save(contact);
        log.info("Contact is added with id :{}",savedContact.getId());
        return savedContact;
    }

    @Override
    public ContactDetails updateContact(ContactDetails contact) {
        return contactRepo.save(contact);
    }

    @Override
    public boolean deleteContact(UUID id) {
        contactRepo.deleteById(id);
        return true;
    }

    @Override
    public List<ContactDetails> searchContacts(String name) {
        return contactRepo.findByNameContaining(name);
    }
}
