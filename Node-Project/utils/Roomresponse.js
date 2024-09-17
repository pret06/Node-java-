function RoomResponse(room) {
    return {
      id: room.id,
      roomName: room.roomName,
      isBooked: room.isBooked,
      bookingNumber: room.bookingNumber,
      roomPrice: room.roomPrice,
      photo: room.photo ? Buffer.from(room.photo).toString('base64') : null,
      bookings: room.bookings ? room.bookings.map(booking => BookedRoomResponse(booking)) : [],
    };
  }
  
  export default RoomResponse;