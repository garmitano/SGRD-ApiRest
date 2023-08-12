package com.sgrd.management.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sgrd.management.dto.PersonDto;
import com.sgrd.management.dto.PersonMapper;
import com.sgrd.management.model.Person;
import com.sgrd.management.service.implementation.PersonServiceImpl;

@RestController
public class PersonController {
    @Autowired
    private PersonServiceImpl service;
    @Autowired
    private PersonMapper mapper;

    @GetMapping("/persons")
    public ResponseEntity<List<PersonDto>> listAllPerson() throws Exception {
        List<Person> listPersons = service.listAll();
        List<PersonDto> listPersonDto = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Person person : listPersons) {
            listPersonDto.add(modelMapper.map(person, PersonDto.class));
        }
        return ResponseEntity.ok(listPersonDto);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable Long id) throws Exception {
        Person person = service.getOneById(id);
        PersonDto personDto = mapper.entityToDto(person);
        return ResponseEntity.ok(personDto);
    }
}
