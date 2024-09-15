package com.response;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;
import com.model.BookedRoom;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class RoomResponse {
    private Long id;
    private String roomName;
    private boolean isBooked;
    private String bookingNumber; 
    private BigDecimal roomPrice;
    private String photo;
    private List<BookedRoom> bookings;


    public RoomResponse(Long id, String roomName, BigDecimal roomPrice) {
        this.id = id;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
    }

   
    public RoomResponse(Long id, String roomName, boolean isBooked, String bookingNumber, BigDecimal roomPrice,
            byte[] photoBytes, List<BookedRoom> bookings) {

        this.id = id;
        this.roomName = roomName;
        this.isBooked = isBooked;
        this.bookingNumber = bookingNumber;
        this.roomPrice = roomPrice;
        this.photo = photoBytes != null ? Base64.getEncoder().encodeToString(photoBytes) : null;
        this.bookings = bookings;
    }

}
