package com.example.AddresBookApi.controller;

import com.example.AddresBookApi.dto.ContactDTO;
import com.example.AddresBookApi.entity.Contact;
import com.example.AddresBookApi.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class Controller {

    private final ContactService contactService;



    @GetMapping
    public Iterable<Contact>list(){
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id){
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody ContactDTO contactDTO){
        return contactService.create(contactDTO);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id,
                          @RequestBody ContactDTO contactDTO){
        return contactService.update(id, contactDTO);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        contactService.delete(id);
    }
}
