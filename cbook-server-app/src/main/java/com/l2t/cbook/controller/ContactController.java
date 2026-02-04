package com.l2t.cbook.controller;

import com.l2t.cbook.domain.ContactDetails;
import com.l2t.cbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ContactDetails addContact(@RequestBody ContactDetails contactDetails){
        return contactService.addContact(contactDetails);
    }

    @GetMapping("/all")
    public List<ContactDetails> getAllContacts(){
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ContactDetails getContactById(@PathVariable UUID id){
        return contactService.getContactById(id);
    }

    @GetMapping("/search/{name}")
    public List<ContactDetails> searchContacts(@PathVariable String name){
        return contactService.searchContacts(name);
    }

    @DeleteMapping("/{id}")
    public boolean deleteContact(@PathVariable UUID id){
        return contactService.deleteContact(id);
    }

    @PutMapping
    public ContactDetails updateContact(@RequestBody ContactDetails contactDetails){
        return contactService.updateContact(contactDetails);
    }

}
