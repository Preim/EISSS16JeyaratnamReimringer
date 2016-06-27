//dependencies:
var restful = require('node-restful');
var mongoose = restful.mongoose;

//Schema:
var statusSchema = new mongoose.Schema({
	hundename: type: String,
	rasse: String,
	geschlecht: String,
	gewicht: Number,
	groesse: Number,
	alter: Number
});

//return models:
module.exports = restful.model('dogs', statusSchema);