package com.example.AddresBookApi.repository;

import com.example.AddresBookApi.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
