package com.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter


public class BookedRoom {
    @Id
    @Column(name = "Booking_Id")
    private Long bookingId;             // Unique ID for the booking

    @Column(name = "Guest_Name")
    private String guestName;           // Name of the guest who booked the room

    @Column(name = "Check_in")
    private LocalDate checkInDate;      // Check-in date

    @Column(name = "Check_out")
    private LocalDate checkOutDate;     // Check-out date

    @Column(name = "Num_of_Adults")
    private int numOfAdults;            // Number of adults in the booking

    @Column(name = "Num_of_Children")
    private int numOfChildren;          // Number of children in the booking

    @Column(name = "Guest_Email")
    private String guestEmail;          // Email of the guest

    @Column(name = "Checked_In")
    private boolean isCheckedIn;        // Status whether the guest has checked in

    @Column(name = "Booking_Confirmed")
    private boolean isBookingConfirmed; // Whether the booking is confirmed

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Room_id")
    private Room room;                // Room acquired

    @Column(name = "Total_Num_of_Guest")
    private int TotalNumofGuest;        //Total Guest


public void calculateTotalNumOfGuest(){
    this.TotalNumofGuest = this.numOfAdults + numOfChildren;
}


public void setNumOfAdults(int numOfAdults) {
    this.numOfAdults = numOfAdults;
    calculateTotalNumOfGuest();
}


public void setNumOfChildren(int numOfChildren) {
    this.numOfChildren = numOfChildren;
    calculateTotalNumOfGuest();
}


public void setBookingConfirmed(boolean isBookingConfirmed) {
    this.isBookingConfirmed = isBookingConfirmed;
}


public void setRoom(Room room2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setRoom'");
}

public void setBookingNumber(String booking) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setBookingNumber'");
}




 


}


