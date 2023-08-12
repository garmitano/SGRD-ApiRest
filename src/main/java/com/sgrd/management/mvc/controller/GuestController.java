package com.sgrd.management.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.sgrd.management.model.Person;
import com.sgrd.management.service.implementation.PersonServiceImpl;

public class GuestController {

    @Autowired
    private PersonServiceImpl service;

    @GetMapping("/guest")
    public List<Person> listAllGuest() throws Exception {
        return service.listAll();
    }
}
