const { Sequelize } = require('sequelize')

const sequelize = new Sequelize('hotel_booking', 'root', 'admin', {
    dialect:'mysql',
    host:'localhost',
    logging:false,
    port:3306,
    define:{
        freezeTableName:true
    },
    sync:{
        alter:true
    }
})

const connectDB = async () =>{
    try {
        sequelize.authenticate()
        console.log("Connected to DB"); 
    } catch (error) {
        console.log("Getting error while Connecting" ,error);
    }
}

connectDB()

module.exports = sequelize
