const { DataTypes } = require('sequelize');
const sequelize = require('../database/db.js');
const Room = require('./Roomschema.js');

const BookedRoom = sequelize.define('BookedRoom', {
    bookingId: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true
    },
    guestName: {
        type: DataTypes.STRING,
        allowNull: false,
    },
    checkInDate: {
        type: DataTypes.DATEONLY,
        allowNull: false,
    },
    checkOutDate: {
        type: DataTypes.DATEONLY,
        allowNull: false,
    },
    numOfAdults: {
        type: DataTypes.INTEGER,
        allowNull: false,
    },
    numOfChildren: {
        type: DataTypes.INTEGER,
        allowNull: false,
    },
    guestEmail: {
        type: DataTypes.STRING,
        allowNull: false,
    },
    isCheckedIn: {
        type: DataTypes.BOOLEAN,
        defaultValue: false,
    },
    isBookingConfirmed: {
        type: DataTypes.BOOLEAN,
        defaultValue: false,
    },
    totalNumOfGuest: {
        type: DataTypes.INTEGER,
        allowNull: false,
    },
    roomId: {
        type: DataTypes.BIGINT,
        references: {
            model: Room,
            key: 'id',
        },
    }
}, {
    tableName: 'BookedRoom',
    timestamps: false
});

BookedRoom.belongsTo(Room, { foreignKey: 'roomId', as: 'room' });

module.exports = BookedRoom;
