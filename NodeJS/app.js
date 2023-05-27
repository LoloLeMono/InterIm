const { json } = require("express");
var express = require("express");
var app = express();
app.use(express.json());
var MongoClient = require("mongodb").MongoClient;
var url = "mongodb://localhost:27017";
const port = 3000;
app.listen(port);
console.log("Serveur écoute sur le port "+port);

const client = new MongoClient(url);
const { ObjectId } = require('mongodb');

async function main() //principe de promesse
{
	client.connect()
    .then( //apeller apres la réponse du serveur
        client => { return client.db("DATABASE"); } //client = objet js qui correpond à la base de donnée
    )
	// Affichage des collection de la db
    .then(async (db) => {
		console.log("Liste des collections :");
		let collections = await db.listCollections().toArray();
		for (let collection of collections) {
			console.log(collection.name);
		}
		return db;
	})
	.then((db) => {
		
        // RETOURNE LA LISTE DES UTILISATEURS
		app.get("/users", async (req, res) => {
			console.log("/users");
			let documents = await db.collection("users")
							.find()
							.toArray();
			res.json(documents);
		});

        //VERIFIE UN UTILISATEUR
        app.post("/login", async (req, res) => {
			console.log("/login");
            let document = await db.collection("users").find(req.body).toArray();
			if( document.length == 1){
				res.json({"resultat" : 0, "message": "Utilisateur trouvé !"});
			}
			else{
				res.json({"resultat" : 1, "message": "Utilisateur inconnu"});
				console.log(req.body);
			}
        });

        //AJOUTER UN UTILISATEUR
        app.post("/signup", async (req, res) => {
			console.log("/inscription");
            let document = await db.collection("users").find(req.body).toArray();
			if( document.length == 1){
				res.json({"resultat" : 0, "message": "L'utilisateur existe déjà"});
			}
			else{
				await db.collection("users").insertOne(req.body);
				res.json({"resultat" : 1, "message": "Nouvel utilsateur ajouté !"});
			}
        });

		// RETOURNE UNE LISTE D'OFFRES SUIVANTS DES CRITERES
		app.post("/find-offers", async (req, res) => {
			console.log("/find-offers");
            let offers = await db.collection("offers").find(req.body).toArray();
			if( offers.length > 0){
				res.json(offers);
			}
			else{
				res.json(null);
			}
		});
    });
}
main();