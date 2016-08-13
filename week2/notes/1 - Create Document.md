# Create a document

### About _id
---

`_id` : unique id / unique primary index (timestamp/ mac address / pid / counter)

### InsertOne 
---

    db.moviesScratch.insertOne({ "title": "Rocky", "year": "1976", "imdb": "tt0075148"});
    db.moviesScratch.insertOne({ "_id": "tt0075148", "title": "Rocky", "year": "1976" });

### InsertMany
---

    db.moviesScratch.insertMany(
        [
            {
    	    "_id" : "tt0084726",
    	    "title" : "Star Trek II: The Wrath of Khan",
    	    "year" : 1982,
    	    "type" : "movie"
            },
            {
    	    "_id" : "tt0796366",
    	    "title" : "Star Trek",
    	    "year" : 2009,
    	    "type" : "movie"
            },
            {
    	    "_id" : "tt0084726",
    	    "title" : "Star Trek II: The Wrath of Khan",
    	    "year" : 1982,
    	    "type" : "movie"
            },
            {
    	    "_id" : "tt1408101",
    	    "title" : "Star Trek Into Darkness",
    	    "year" : 2013,
    	    "type" : "movie"
            },
            {
    	    "_id" : "tt0117731",
    	    "title" : "Star Trek: First Contact",
    	    "year" : 1996,
    	    "type" : "movie"
            }
        ]
    );

### InsertMany unordered (allow to not stop when error)
---

    db.moviesScratch.insertMany(
        [
            {
    	    "_id" : "tt0084726",
    	    "title" : "Star Trek II: The Wrath of Khan",
    	    "year" : 1982,
    	    "type" : "movie"
            },
            {
    	    "_id" : "tt0796366",
    	    "title" : "Star Trek",
    	    "year" : 2009,
    	    "type" : "movie"
            },
            {
    	    "_id" : "tt0084726",
    	    "title" : "Star Trek II: The Wrath of Khan",
    	    "year" : 1982,
    	    "type" : "movie"
            },
            {
    	    "_id" : "tt1408101",
    	    "title" : "Star Trek Into Darkness",
    	    "year" : 2013,
    	    "type" : "movie"
            },
            {
    	    "_id" : "tt0117731",
    	    "title" : "Star Trek: First Contact",
    	    "year" : 1996,
    	    "type" : "movie"
            }
        ],
        {
            "ordered": false 
        }
    );



