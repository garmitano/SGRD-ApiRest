package com.sgrd.management.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgrd.management.model.Person;
import com.sgrd.management.repository.IPersonRepository;

@Service
public class PersonServiceImpl implements IServiceBase<Person> {

    @Autowired
    private IPersonRepository repository;

    @Override
    public List<Person> listAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public Person addNewOne(Person entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addNewOne'");
    }

    @Override
    public Person getOneById(Long id) throws Exception {
        Person person = repository.getReferenceById(id);
        return person;

    }

    @Override
    public Person updateOne(Person entity, Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOne'");
    }

    @Override
    public void deleteOne(Long id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOne'");
    }

}
