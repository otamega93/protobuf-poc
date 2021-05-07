package com.example.protobufpoc.controllers;

import com.example.protobufpoc.models.Person;
import com.example.protobufpoc.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    public Person getPerson(@PathVariable int id){
        return this.personService.getPerson(id);
    }

    @PostMapping(value = "")
    public void createPerson(@RequestBody Person person) {

        this.personService.addPerson(person);
    }
}
