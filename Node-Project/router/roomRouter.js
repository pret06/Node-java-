const express = require('express')
const router = express.Router()
const roomController = require('../controller/roomcontroller.js')
const multer = require('multer')

const upload = multer();

router.post('/add/new-room', upload.single('photo'), roomController.addnewroom)

module.exports = router