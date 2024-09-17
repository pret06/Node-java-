const RoomResponse = require('../utils/Roomresponse')
const RoomService =  require('../service/roomservice').default

exports.addnewroom = async(req,res)=>{
    try {
        const {roomType, roomPrice} = req.body
        const file = req.file

        const savedRoom = await RoomService.addnewroom(file, roomType , roomPrice)
        const roomresponse = new RoomResponse(savedRoom.id , savedRoom.roomName , savedRoom.roomPrice)
        
        return res.status(200).json({roomresponse})
    } catch (error) {
        console.error(error);
        return res.status(500).json({ message: 'Internal server error' });
    }
}