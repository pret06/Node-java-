const path = require('path')

exports.validateFileType = (file , allowedTypes = ['image/jpeg', 'image/png']) =>{
    if(!file) return false
    return allowedTypes.includes(file.mimetype)
}

exports.validatefileSize = (file, maxSize = 5 * 1024 * 1024) =>{
    if(!file) return false
    return file.size <= maxSize
}

exports.generateuniqueFilename = (file) =>{
    const ext = path.extname(file.originalname)
    const filename = Date.now() + '-' + Math.round(Math.random() * 1E9);
    return `${filename}${ext}`
}

