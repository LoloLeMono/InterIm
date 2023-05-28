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

		// RETOURNE LA LISTE DES OFFRES
		app.get("/offers", async (req, res) => {
			console.log("/offers");
			let documents = await db.collection("offers")
							.find()
							.toArray();
			res.json(documents);
		});

        //VERIFIE UN UTILISATEUR
        app.post("/login", async (req, res) => {
			console.log("/login");
            let document = await db.collection("users").findOne(req.body);
			if( document != null){
				res.json(document);
			}
			else{
				res.json(null);
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
		
			const { date, secteur, ville } = req.body; // Extraire les arguments spécifiques du corps de la requête
		
			const query = {}; // Créer un objet vide pour la requête
		
			if (date) {
				query.date = { $eq: date }; // Utiliser l'opérateur $eq pour comparer les dates égales
			}
		
			if (secteur) {
				query.secteur = secteur; // Ajouter l'argument secteur à la requête si présent
			}
		
			if (ville) {
				query.ville = ville; // Ajouter l'argument ville à la requête si présent
			}
		
			let offers = await db.collection("offers").find(query).toArray();
		
			if (offers.length > 0) {
				res.json(offers);
			} else {
				res.json(null);
			}
		});
		
		
    });
}
main();