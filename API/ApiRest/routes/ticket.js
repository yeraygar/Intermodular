const express = require("express");
const router = express.Router();
const ticketSchema = require("../models/ticket");

//Create new ticket
router.post("/ticket", (req, res) => {
    const ticket = ticketSchema(req.body);
    ticket
        .save()
        .then((data) =>{
            res.json(data);
            console.log(`\nNew ticket: \n ${data}`);
        })
        .catch((err) => {
            res.json({message:err});
            console.error(`Error get /api/ticket : ${err}`);
        })
})

//Get specific ticket
router.get("/ticket/:id", (req, res) => {
    const {id} = req.params;
    ticketSchema
        .findById(id)
        .then((data) =>{
            res.json(data);
            console.log(`\nticket: \n ${data}`);
        })
        .catch((err) => {
            res.json({message:err});
            console.log(`Error get /api/ticket/${id} : ${err}`);
        })
})

//Update ticket, si algun campo no se pone no se elimina
router.put("/ticket/:id", (req, res) => {
    const {id} = req.params;
    const {name, email, active} = req.body;
    ticketSchema
        .updateOne({_id: id}, {$set:{name, email, active}})
        .then((data) =>{
            res.json(data);
            console.log(`\nticket Update succesful: \n ${data}`);
        })
        .catch((err) => {
            res.json({message:err});
            console.log(`ticket Error update : ${err}`);
        })
})

//Delete ticket
router.delete("/ticket/:id", (req, res) => { 
    const {id} = req.params;
    ticketSchema
        .remove({_id: id})
        .then((data) =>{
            res.json(data);
            console.log(`\nticket Delete succesful: \n ${data}`);
        })
        .catch((err) => {
            res.json({message:err});
            console.log(`ticket Error delete : ${err}`);
        })
})

//Get all ticket from a client
router.get("/ticket/client/:id_client", (req, res) => {
    const {id_client} = req.params;
    ticketSchema
        .find({id_client: id_client})
        .then((data) =>{
            res.json(data);
            console.log(`\nticket: \n ${data}`);
        })
        .catch((err) => {
            res.json({message:err});
            console.log(`Error get /api/ticket/client/${id} : ${err}`);
        })
})







module.exports = router