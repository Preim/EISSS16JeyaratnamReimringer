//dependencies:
var express = require('express');
var router = express.Router();

//get models:
var Status = require('../models/user');


//routes:
Status.methods(['get', 'post', 'put', 'delete']);
Status.register(router, '/user');

//return router:
module.exports = router;