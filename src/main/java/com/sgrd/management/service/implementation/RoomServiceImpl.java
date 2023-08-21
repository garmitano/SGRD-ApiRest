package com.sgrd.management.service.implementation;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.type.TypeVariableToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgrd.management.dto.RoomDto;
import com.sgrd.management.dto.RoomDtoWithPrice;
import com.sgrd.management.model.Room;
import com.sgrd.management.repository.IRoomRepository;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomRepository repository;

    @Autowired
    private ModelMapper mapper;

    public List<RoomDto> listRooms() throws Exception {
        try {
            // List<Room> rooms = repository.listRooms();
            // List<RoomDto> listRoomDto = new ArrayList<>();
            // for (Room room : rooms) {
            //     listRoomDto.add(mapper.map(room, RoomDto.class));
            // }
            // return listRoomDto;
            return repository.listRooms();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<RoomDtoWithPrice> listVacant() throws Exception {
        try {
            List<Object[]> listRooms = repository.freeRoomsWithPrice();
            List<RoomDtoWithPrice> listRoomDto = new ArrayList<>();
            for (Object[] room : listRooms) {
                int nro = (Integer) room[0];
                double price = (Double) room[1];
                String type = (String) room[2];

                RoomDtoWithPrice dto = new RoomDtoWithPrice();
                dto.setNro_room(nro);
                dto.setPrice(price);
                dto.setType(type);

                listRoomDto.add(dto);

            }
            return listRoomDto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

        public List<RoomDto> listOccupied() throws Exception {
        try {
            List<Room> rooms = repository.listOccupied();
            List<RoomDto> listRoomDto = new ArrayList<>();
            for (Room room : rooms) {
                listRoomDto.add(mapper.map(room, RoomDto.class));
            }   
            return listRoomDto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public List<RoomDtoWithPrice> listFreeWithPrice() throws Exception {
        try {
            List<Object[]> rooms = repository.freeRoomsWithPrice();

   
            return null;

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
    public List<Room> listAllRoom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAllRoom'");
    }

    @Override
    public Room addNewRoom(Room room) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addNewRoom'");
    }

    @Override
    public Room getRoomById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoomById'");
    }

    @Override
    public Room updateRoom(Room room) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRoom'");
    }

    @Override
    public void deleteRoom(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRoom'");
    }

}