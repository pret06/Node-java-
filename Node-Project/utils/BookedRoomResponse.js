function BookedRoomResponse(bookedRoom) {
    return {
      bookingId: bookedRoom.bookingId,
      guestName: bookedRoom.guestName,
      checkInDate: bookedRoom.checkInDate,
      checkOutDate: bookedRoom.checkOutDate,
      numOfAdults: bookedRoom.numOfAdults,
      numOfChildren: bookedRoom.numOfChildren,
      guestEmail: bookedRoom.guestEmail,
      isCheckedIn: bookedRoom.isCheckedIn,
      isBookingConfirmed: bookedRoom.isBookingConfirmed,
      room: bookedRoom.room ? bookedRoom.room.roomName : null,
      totalNumOfGuest: bookedRoom.numOfAdults + bookedRoom.numOfChildren,
    };
  }
  
  export default BookedRoomResponse;