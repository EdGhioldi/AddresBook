package com.example.AddresBookApi.controller;

import com.example.AddresBookApi.entity.Contact;
import com.example.AddresBookApi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/api/contacts")
@RestController
public class Controller {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public Iterable<Contact>list(){
        return contactRepository.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id){
        return contactRepository
                .findById(id)
                .orElse(null);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody Contact contact){
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id,
                          @RequestBody Contact form){
        Contact contactFromDB = contactRepository
                .findById(id)
                .orElse(null);

        contactFromDB.setName(form.getName());
        contactFromDB.setEmail(form.getEmail());

        return contactRepository.save(contactFromDB);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Contact contactFromDB = contactRepository
                .findById(id)
                .orElse(null);
        contactRepository.delete(contactFromDB);
    }
}
