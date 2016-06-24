//dependencies:
var restful = require('node-restful');
var mongoose = restful.mongoose;

//Schema:
var statusSchema = new mongoose.Schema({
	username: {type: String, unique: true},
	passwort: String,
	email: String
});

//return models:
module.exports = restful.model('user', statusSchema);