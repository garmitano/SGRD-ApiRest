package com.sgrd.management.dto;

import com.sgrd.management.model.RoomType;
import com.sgrd.management.model.Enum.RoomStateEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private int nro_room;
    private RoomStateEnum state;
    private String detail;
    private Long type;
}
