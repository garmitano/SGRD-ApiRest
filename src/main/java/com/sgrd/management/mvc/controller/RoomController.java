package com.sgrd.management.mvc.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sgrd.management.dto.RoomDto;
import com.sgrd.management.dto.RoomDtoWithPrice;
import com.sgrd.management.service.implementation.RoomServiceImpl;

@RestController
public class RoomController {

    @Autowired
    private RoomServiceImpl service;

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDtoWithPrice>> listAllRooms() throws Exception {
        return ResponseEntity.ok(service.listFree());
    }

    @GetMapping("/rooms/free")
    public ResponseEntity<List<RoomDtoWithPrice>> listFreeRooms() throws Exception {
        return ResponseEntity.ok(service.listFreeWithPrice());
    }

    @GetMapping("/rooms/free/{id}")
    public ResponseEntity<RoomDto> getRoomDtoById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(service.getRoomDtoById(id));
    }

    @GetMapping("/rooms/{nro}")
    public ResponseEntity<RoomDto> getOneById(@PathVariable int nro) throws Exception {
        ModelMapper mapper = new ModelMapper();
        return ResponseEntity.ok(mapper.map(service.getOneByNro(nro), RoomDto.class));
    }
}