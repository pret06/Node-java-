package com.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates unique ID
    @Column(name = "Room_Id")  // Column name in the database
    private Long id;            // Room ID

    @Column(name = "Room_Name", nullable = false)
    private String roomName;     // Name of the room

    @Column(name = "Is_Booked")
    private boolean isBooked;    // Booking status

    @Column(name = "Booking_Number", nullable = false, unique = true)
    private String bookingNumber;       // Unique booking number


    @Column(name = "Room_Price", nullable = false)
    private BigDecimal roomPrice; // Price of the room per night

    @Column(name = "Room_Type", nullable = false)   // Added roomType field
    private String roomType;     // Type of the room


    @Lob
    @Column(name = "Photo")
    private Blob photo;
    

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookedRoom> bookings;  // List of bookings for the room

    public void setBookings(List<BookedRoom> bookings) {
        this.bookings = bookings;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public void addbooking(BookedRoom bookedRoom){
          if(this.bookings == null){
           this.bookings = new ArrayList<>();
          }

          this.bookings.add(bookedRoom);
          bookedRoom.setRoom(this);

          this.isBooked = true;
          String booking = RandomStringUtils.randomNumeric(10);
          bookedRoom.setBookingNumber(booking);
    }

    public void setRoomType(String roomType) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setRoomType'");
    }

}
