package com.example.AddresBookApi.service;

import com.example.AddresBookApi.dto.ContactDTO;
import com.example.AddresBookApi.entity.Contact;
import com.example.AddresBookApi.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public Iterable<Contact>findAll(){
        return contactRepository.findAll();
    }

    public Contact findById(Integer id){
        return contactRepository
                .findById(id)
                .orElse(null);
    }

    public Contact create(ContactDTO contactDTO){
        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, ContactDTO contactDTO){
        Contact contactFromDB = findById(id);

        contactFromDB.setName(contactDTO.getName());
        contactFromDB.setEmail(contactDTO.getEmail());

        return contactRepository.save(contactFromDB);
    }

    public void delete(Integer id){
        Contact contactFromDB = findById(id);
        contactRepository.delete(contactFromDB);
    }
}
