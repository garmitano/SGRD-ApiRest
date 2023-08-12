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
import com.sgrd.management.dto.RoomDto;
import com.sgrd.management.model.Person;
import com.sgrd.management.model.Room;
import com.sgrd.management.service.implementation.RoomServiceImpl;

@RestController
public class RoomController {

    @Autowired
    private RoomServiceImpl service;

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDto>> listAllRooms() throws Exception {
        List<Room> listRooms = service.listAll();
        List<RoomDto> listRoomDtos = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (Room room : listRooms) {
            listRoomDtos.add(mapper.map(room, RoomDto.class));
        }
        return ResponseEntity.ok(listRoomDtos);
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<RoomDto> getPersonById(@PathVariable Long id) throws Exception {
        Room room = service.getOneById(id);
        ModelMapper mapper = new ModelMapper();
        RoomDto rommDto = mapper.map(room, RoomDto.class);
        return ResponseEntity.ok(rommDto);
    }

}