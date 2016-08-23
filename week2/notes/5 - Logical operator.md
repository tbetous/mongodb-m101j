#Comparaison operators

### All documentation
---

All operators can be found on the official documentation : https://docs.mongodb.com/manual/reference/operator/query-logical/

| Operator | Description                                                                                                 |
|----------|-------------------------------------------------------------------------------------------------------------|
| `$or`    | Joins query clauses with a logical **OR** returns all documents that match the conditions of either clause. |
| `$and`   | Joins query clauses with a logical **AND** returns all documents that match the conditions of both clauses. |
| `$not`   | Inverts the effect of a query expression and returns documents that do not match the query expression.      |
| `$nor`   | Joins query clauses with a logical **NOR** returns all documents that fail to match both clauses.           |


### Example : $or operator
--- 
Find movies with tomato.meter greather than 99 **OR** with metacritic greather than 95 :

	db.movieDetails.find({ $or : [ { "tomato.meter": { $gt: 99 } },{ "metacritic": { $gt: 95 } } ] })

### Example : $and operator
--- 
Find movies with metacritic not equals to 100 **AND** with a metacritic value :

	db.movieDetails.find({ $and : [ { "metacritic": { $ne: 100 } },{ "metacritic" { $exists: true } } ] })

*Note : Allows to avoid constraint of json with same identifier.*








