package com.sgrd.management.dto;

import org.springframework.stereotype.Component;

import com.sgrd.management.model.Person;

@Component
public class PersonMapper {
    public PersonDto entityToDto(Person person) {
        PersonDto dto = new PersonDto();
        dto.setId(person.getIdPerson());
        dto.setDni(person.getDni());
        dto.setFullName(person.getFullName());
        dto.setProvince(person.getProvince());

        return dto;
    }

    public Person dtoToEntity(PersonDto personDto) {
        Person person = new Person();
        person.setIdPerson(personDto.getId());
        person.setDni(personDto.getDni());
        person.setFullName(personDto.getFullName());
        person.setProvince(personDto.getProvince());
        return person;
    }
}
