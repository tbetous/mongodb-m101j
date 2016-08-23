#Query array operators

### Regex operator documentation
---

All operators can be found on the official documentation : https://docs.mongodb.com/manual/reference/operator/query-array/

| Operator     | Description                                                                                       |
|--------------|---------------------------------------------------------------------------------------------------|
| `$all`       | Matches arrays that contain all elements specified in the query.                                  |
| `$elemMatch` | Selects documents if element in the array field matches all the specified $elemMatch conditions.  |
| `$size`      | Selects documents if the array field is a specified size.                                         |

### Example : $all
--- 

Find movies where *Comedy* **AND** *Crime* **AND** *Drama* are in genres :

	db.movieDetails.find({ genres: { $all: ["Comedy", "Crime", "Drama"] } }).pretty()

### Example : $size
--- 

Find movies where countries contains one element : 

	db.movieDetails.find({ countries: { $size: 1 } }).pretty()

### Example : $elemMatch
--- 

Find movies where box office contains element with UK version **OR** a revenue greather than 15 :
 
	db.movieDetails.find({ boxOffice: { country: "UK", revenue: { $gt: 15 } } })

Find movies where box office contains element with UK version **AND** a revenue greather than 15 :

	db.movieDetails.find({ boxOffice: {$elemMatch: { country: "UK", revenue: { $gt: 15 } } } })












