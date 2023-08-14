package com.sgrd.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgrd.management.model.Room;

public interface IRoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "SELECT * FROM habitaciones WHERE state = 'LIBRE'", nativeQuery = true)
    List<Room> freeRooms();

    @Query(value = "SELECT hab.nro_room AS nroRoom, tipo_hab.price AS price FROM habitaciones hab JOIN tipos_de_habitacion tipo_hab ON hab.fk_room_type = tipo_hab.id_room_type WHERE hab.state='LIBRE'", nativeQuery = true)
    List<Room> freeRoomsWithPrice();

    @Query(value = "SELECT hab.detail, hab.fk_room_type, hab.state FROM habitaciones hab WHERE hab.nro_room = 4", nativeQuery = true)
    Room getRoomByNroRoom(int nro);
}