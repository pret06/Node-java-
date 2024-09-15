package com.controller;

import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.model.Room;
import com.response.RoomResponse;
import com.service.IRoomservice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class RoomController {

    private final IRoomservice roomservice;

    public ResponseEntity<RoomResponse>addNewRoom(
        @RequestParam("photo") MultipartFile photo,
        @RequestParam("RoomType") String Roomtype,
        @RequestParam("roomprice") BigDecimal roomprice
    ){
        Room savedRoom = roomservice.addNewRoom(photo, Roomtype, roomprice);
        RoomResponse response = new RoomResponse(savedRoom.getId(), savedRoom.getRoomName() ,savedRoom.getRoomPrice());
        return ResponseEntity.ok(response);
    }
}
