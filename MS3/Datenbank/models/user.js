//dependencies:
var restful = require('node-restful');
var mongoose = restful.mongoose;

//Schema:
var user = new mongoose.Schema({
	username: {type: String, unique: true},
	passwort: String,
	email: String,
	hund: {
		name: String,
		rasse: String,
		gewicht: Number,
		groesse: Number,
		alter: Number
	}
});

//return models:
module.exports = restful.model('user', user);