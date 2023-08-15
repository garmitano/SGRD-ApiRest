package com.sgrd.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgrd.management.model.Room;

public interface IRoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "SELECT hab.id_room, hab.nro_room, hab.detail, hab.state, hab.fk_room_type FROM habitaciones hab WHERE state = 'LIBRE'", nativeQuery = true)
    List<Room> listVacant();

    @Query(value = "SELECT hab.id_room, hab.nro_room, hab.detail, hab.state, hab.fk_room_type FROM habitaciones hab WHERE state = 'OCUPADA'", nativeQuery = true)
    List<Room> listOccupied();

    @Query(value = "SELECT hab.nro_room, tipo_hab.price, tipo_hab.type " 
                                        + "FROM habitaciones hab "
                                        + "JOIN tipos_de_habitacion tipo_hab " 
                                        + "ON hab.fk_room_type = tipo_hab.id_room_type " 
                                        + "WHERE hab.state='LIBRE'", 
                                        nativeQuery = true)
    List<Object[]> freeRoomsWithPrice();

    @Query(value = "SELECT hab.id_room, hab.nro_room, hab.detail, hab.state, hab.fk_room_type FROM habitaciones hab WHERE hab.nro_room = ?1", nativeQuery = true)
    Room getRoomByNroRoom(int nro);
}