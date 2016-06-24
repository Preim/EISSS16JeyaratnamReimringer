//dependencies:
var express = require('express');
var mongoose = require('mongoose');
var bodyParser = require('body-parser');

//connect to mongoDB:
mongoose.connect('mongodb://user:12345@ds013664.mlab.com:13664/healthydogdb');

//express:
var app = express();
app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

//routes:
app.use('/api',require('./routes/api'));


//start server:
app.listen(1000);
console.log('Server is running on port 1000');