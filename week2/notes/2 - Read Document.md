#Read a document

###Find simple element
---

Find movies that are rated as PG-13

    db.movieDetails.find( {rated: "PG-13"} ).pretty()

Find movies that has tomato.meter to 100

    db.movieDetails.find( {"tomato.meter": 100} ).pretty()

###Find elements in an array
---

Find exact match, exact order

    db.movieDetails.find( {"writers": ["Ethan Coen", "Joel Coen"]} ).pretty()

Find Jeff Bridges in actors

    db.movieDetails.find( {"actors": "Jeff Bridges"} ).pretty()

Find Jeff Bridges in actors at the first position

    db.movieDetails.find( {"actors.0": "Jeff Bridges"} ).pretty()

###Using cursor
---

    var c = db.movieDetails.find()
    var doc = function() {return c.hasNext() ? c.next() : null;}
    c.objsLeftInBatch()
    doc()
    doc()
    doc() etc...

###Projection
---
Allows to show only title

    db.movieDetails.find({ rated: "PG" }, {title: 1, _id: 0}).pretty()



