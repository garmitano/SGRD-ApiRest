package com.sgrd.management.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgrd.management.dto.RoomDto;
import com.sgrd.management.dto.RoomDtoWithPrice;
import com.sgrd.management.model.Room;
import com.sgrd.management.repository.IRoomRepository;

import jakarta.transaction.Transactional;

@Service
public class RoomServiceImpl implements IServiceBase<Room> {

    @Autowired
    private IRoomRepository repository;

    @Override
    @Transactional
    public List<Room> listAll() throws Exception {
        try {
            List<Room> rooms = repository.findAll();
            return rooms;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<RoomDtoWithPrice> listFree() throws Exception {
        try {
            ModelMapper mapper = new ModelMapper();
            List<Room> rooms = repository.freeRooms();
            return rooms.stream()
                    .map(room -> mapper.map(room, RoomDtoWithPrice.class))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<RoomDtoWithPrice> listFreeWithPrice() throws Exception {
        ModelMapper mapper = new ModelMapper();
        try {
            List<Room> rooms = repository.freeRoomsWithPrice();
            return rooms.stream()
                    .map(room -> mapper.map(room, RoomDtoWithPrice.class))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Room addNewOne(Room entity) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Room getOneById(Long id) throws Exception {
        try {

            return repository.getReferenceById(id);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Room getOneByNro(int nro) throws Exception {
        try {
            return repository.getRoomByNroRoom(nro);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public RoomDto getRoomDtoById(Long id) throws Exception {
        try {
            ModelMapper mapper = new ModelMapper();
            Room room = repository.getReferenceById(id);
            return mapper.map(room, RoomDto.class);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Room updateOne(Room entity, Long id) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deleteOne(Long id) {
        repository.deleteById(id);
    }

}