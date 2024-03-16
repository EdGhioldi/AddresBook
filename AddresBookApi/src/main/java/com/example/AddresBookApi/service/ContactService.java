package com.example.AddresBookApi.service;

import com.example.AddresBookApi.entity.Contact;
import com.example.AddresBookApi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public Iterable<Contact>findAll(){
        return contactRepository.findAll();
    }
    public Contact findById(Integer id){
        return contactRepository
                .findById(id)
                .orElse(null);
    }

    public Contact create(Contact contact){
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, Contact form){
        Contact contactFromDB = contactRepository
                .findById(id)
                .orElse(null);

        contactFromDB.setName(form.getName());
        contactFromDB.setEmail(form.getEmail());

        return contactRepository.save(contactFromDB);
    }

    public void delete(Integer id){
        Contact contactFromDB = contactRepository
                .findById(id)
                .orElse(null);
        contactRepository.delete(contactFromDB);
    }
}
