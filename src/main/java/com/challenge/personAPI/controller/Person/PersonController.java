package com.challenge.personAPI.controller.Person;

import com.challenge.personAPI.model.PersonModel;
import com.challenge.personAPI.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
@Component
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/visualization")
    public List<PersonResponse> list() {
        ArrayList<PersonResponse> personList = new ArrayList<>();
        personService.findAll().forEach(personModel -> {
            personList.add(PersonMapper.toResponse(personModel));
        });
        return personList;
    }

    @GetMapping("/visualization/{id}")
    public PersonResponse findId(@PathVariable("id") Integer id) {
        PersonModel personModel = personService.findById(id);
        return PersonMapper.toResponse(personModel);
    }

    @PostMapping("/create")
    public PersonModel create(@RequestBody PersonRequest personRequest) {
        PersonModel personModel = PersonMapper.toEntity(personRequest);
        return personService.save(personModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        personService.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/edit/{id}")
    public PersonModel edit(@PathVariable("id") Integer id, @RequestBody PersonRequest personRequest) {
        PersonModel person = PersonMapper.toEntity(personRequest, id);
        return personService.save(person);
    }
}
