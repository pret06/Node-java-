import Room from '../model/Roomschema.js';
import fs from 'fs';
import path from 'path';

async function addnewroom(file , roomType , roomPrice){
    try {
        const room = {
            roomName: roomType,
            roomPrice : roomPrice
        }
        if(file){
            const photoPath = path.join(__dirname, '../uploads', file.filename);
            fs.writeFileSync(photoPath, file.buffer); 
            room.photo = file.filename; 
        }
        const savedRoom = await Room.create(room)
        return savedRoom
    } catch (error) {
        throw new Error('Error while adding new room');
    }
}

export default addnewroom