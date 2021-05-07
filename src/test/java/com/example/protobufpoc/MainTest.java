package com.example.protobufpoc;

import com.example.protobufpoc.models.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

public class MainTest {

    public static void main (String[] args) {

        RestTemplate restTemplate = new RestTemplate(Arrays.asList(new ProtobufHttpMessageConverter()));

        Person person = Person.newBuilder().setAge(20).setName(UUID.randomUUID().toString()).build();

        restTemplate.postForEntity("http://localhost:8080/proto-persons", person, Void.class);

        ResponseEntity<Person> res = restTemplate.getForEntity("http://localhost:8080/proto-persons/1", Person.class);

        System.out.println(res.getBody().toString());
    }
}
