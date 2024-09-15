package com.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.model.Room;
import com.repository.RoomRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@RequestMapping("/room")
public class Roomservice implements IRoomservice{

    private final RoomRepo roomRepo;

    @Override
    @PostMapping("/add/new-room")
    public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) {
        Room room = new Room();
        room.setRoomPrice(roomPrice);
        room.setRoomName(roomType);

        if(!file.isEmpty()){
             try {
                byte[] photoBytes = file.getBytes();
                Blob photoBlob = new SerialBlob(photoBytes);
                room.setPhoto(photoBlob);
            } catch (IOException | SQLException e) {
                e.printStackTrace(); 
            }
        }
       
        return roomRepo.save(room);
    }
    
}
