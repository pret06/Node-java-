package com.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BookedRoomResponse {
    private Long bookingId;
    private String guestName;
    private LocalDate checkInDate; 
    private LocalDate checkOutDate; 
    private int numOfAdults;
    private int numOfChildren;
    private String guestEmail;
    private boolean isCheckedIn;
    private boolean isBookingConfirmed;
    private String room; 
    private int TotalNumofGuest;


    public BookedRoomResponse(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate,
            boolean isBookingConfirmed) {

        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isBookingConfirmed = isBookingConfirmed;

    } 


    

}
