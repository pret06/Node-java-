const express = require('express')
const connectDB = require('./database/db.js')
const roomrouter = require('./router/roomRouter.js')
const app = express()

app.use(express.json())
app.use('/room', roomrouter)



connectDB.then(()=>{
    const PORT = 6000 
    app.listen(PORT, ()=>{
        console.log("Server is working fine");
    }).catch((err)=>{
        console.log("Failed to connect to DB", err)
        process.exit(1)
    })
})




