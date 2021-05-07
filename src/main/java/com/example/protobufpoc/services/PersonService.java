package com.example.protobufpoc.services;

import com.example.protobufpoc.models.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonService {

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    private ConcurrentMap<Integer, Person> personMap = new ConcurrentHashMap<>();

    public void addPerson(Person person) {

        this.personMap.put(atomicInteger.getAndIncrement(), person);
    }

    public Person getPerson(int id) {

        return this.personMap.get(id);
    }

}
