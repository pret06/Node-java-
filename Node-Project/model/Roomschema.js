const {DataTypes} = require('sequelize')
const sequelize = require('../database/db.js')
const BookedRoom = require('./BookedRoomschema.js')

const Room = sequelize.define('Room', {
    id:{
        type:DataTypes.BIGINT,
        autoIncrement:true,
        primaryKey:true
    },
    roomName:{
       type:DataTypes.STRING,
       allownull:false
    },
    isBooked:{
      type:DataTypes.BOOLEAN,
      defaultvalue:false
    },
    bookingNumber:{
      type:DataTypes.STRING,
      unique:true
    },
    roomPrice:{
      type:DataTypes.DECIMAL,
      allownull:false
    },
    roomType:{
      type:DataTypes.STRING,
      allownull:false
    },
    photo:{
      type:DataTypes.BLOB('long')
    }
},
{
    tableName:'room',
    timestamps:false
})


Room.hasMany(BookedRoom,{ foreignKey: 'roomId' , as: 'bookings'})


module.exports = Room