#Comparaison operators

### All documentation
---

All operators can be found on the official documentation : https://docs.mongodb.com/manual/reference/operator/query-comparison/

| Operator	| Description								|
|---------------|-----------------------------------------------------------------------|
| `$eq`		| Matches values that are equal to a specified value. 			|
| `$gt`		| Matches values that are greater than a specified value.		|
| `$gte`	| Matches values that are greater than or equal to a specified value.	|
| `$lt`		| Matches values that are less than a specified value.			|
| `$lte`	| Matches values that are less than or equal to a specified value.	|
| `$ne`		| Matches all values that are not equal to a specified value.		|
| `$in`		| Matches any of the values specified in an array.			|
| `$ningt`	| Matches none of the values specified in an array.			|

### Example : simple operator
--- 

Find movies with runtime greather than 90

    db.movieDetails.find({ runtime: { $gt: 90 } }).count()

### Example : multi-operators on same element
--- 

Find movies with runtime greather than 90 and less than 120

    db.movieDetails.find({ runtime: { $gt: 90, $lt: 120 } }).count()

### Example : multi-operators on different elements
--- 

Find movies with tomato.meter greather or equal to 95 and runtime greather than 180

    db.movieDetails.find({ "tomato.meter": { $gte: 95 }, runtime: { $gt: 180 } })

### Example : not equal
--- 

Find movies with rated not equal to "UNRATED"

    db.movieDetails.find({ rated: { $ne: "UNRATED" } }).count()

### Example : equal
--- 

Find movies with rated is equal to G or PG

    db.movieDetails.find({ rated: { $in: ["G", "PG"] } }).pretty()






