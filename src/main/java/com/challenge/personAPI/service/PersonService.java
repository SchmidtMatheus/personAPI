package com.challenge.personAPI.service;

import com.challenge.personAPI.model.PersonModel;
import com.challenge.personAPI.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonModel> findAll() {

        return personRepository.findAll();
    }

    public PersonModel findById(@PathVariable("id") Integer id) {
        return personRepository.findById(id).get();
    }

    @Transactional
    public PersonModel save(PersonModel personModel) {
        return personRepository.save(personModel);
    }

    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        personRepository.deleteById(id);
        return ResponseEntity.accepted().build();
    }

}
