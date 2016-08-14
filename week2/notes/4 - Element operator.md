# Element operators

### All documentation
---

All operators can be found on the official documentation : https://docs.mongodb.com/manual/reference/operator/query-element//operator/query-comparison/

| Operator  | Description                                            |
|-----------|--------------------------------------------------------|
| `$exists` | Matches documents that have the specified field.       |
| `$type`   | Selects documents if a field is of the specified type. |

### Example : $Find
---
Find movies  where tomato.meter field exist
	
	db.moviesDetails.find({ "tomato.meter": { $exists: true } })

Find movies where tomato.meter does not exist

	db.moviesDetails.find({ "tomato.meter": { $exists: false } })

### Example : $Type
---
Find movies where _id is a String

	db.moviesScratch.find({ _id: { $type: "string" } })

*Note : Value of $type may be either a BSON type number or the string alias*

