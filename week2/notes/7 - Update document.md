# Update document

## 1 - How to use insertOne / insertMany / replaceOne

#### **InsertOne**
InsertOne allow to update the first value that matches with the selector :

	db.movieDetails.updateOne({HERE_IS_THE_SELECTOR}, {HERE_IS_THE_ACTION}})
                            
#### **InsertMany**

InsertMany allows to update all documents that matches with the selector :

	db.movieDetails.updateMany({HERE_IS_THE_SELECTOR}, {HERE_IS_THE_ACTION}})
	
#### **ReplaceOne**
Replace a documents by another

	db.movies.replaceOne(
	    {"imdb": detail.imdb.id},
	    detail);

## 2 - Field Update operators

All operators can be found on the official documentation :  https://docs.mongodb.com/manual/reference/operator/update-field/

**Name **|**Description**
-----|-----
`$inc` |Increments the value of the field by the specified amount.
`$mul` |Multiplies the value of the field by the specified amount.
`$rename` |Renames a field.
`$setOnInsert` |Sets the value of a field if an update results in an insert of a document. Has no effect on update operations that modify existing documents.
`$set` |Sets the value of a field in a document.
`$unset` |Removes the specified field from a document.
`$min` |Only updates the field if the specified value is less than the existing field value.
`$max` |Only updates the field if the specified value is greater than the existing field value.
`$currentDate` |Sets the value of a field to current date, either as a Date or a Timestamp.

### 2.1 - Example : $set
---

#### **Set one value**
Set poster value of the first movie that matches with the selector, so a movie with the title *The Martian*

	db.movieDetails.updateOne({title: "The Martian"},
                          { $set: {poster: "new value"} })

#### **Set several values**
Set several values of the first movie that matches with the selector, so a movie with the title *The Martian*

	db.movieDetails.updateOne({title: "The Martian"},
	                          { $set: { "awards" : {"wins" : 8,
			                              "nominations" : 14,
			                                "text" : "Nominated for 3 Golden Globes. Another 8 wins & 14 nominations." } } });

### 2.2 - Example : $inc
---

Updates are used to correct errors and, over time, keep our data current. For movie data, much of what's there is static: directors, authors and the like. Other content such as reviews and ratings will need to be updated as users take action. 

We could use `$set` for this purpose, but that's an error prone approach. It's too easy to do the arithmetic incorrectly. Instead, we have a number of operators that support numeric updates of data: `$min`, `$max`, `$inc`, `$mul`. Let's look at an example using `$inc` to update reviews.

Update tomato.reviews and tomato.userReviews by incrementing of the given value :

	db.movieDetails.updateOne({title: "The Martian"},
                          { $inc: { "tomato.reviews": 3, "tomato.userReviews": 25 } })

## 3 - Array field update oprarators

All operators can be found on the official documentation :  https://docs.mongodb.com/manual/reference/operator/update-array/

##### **Update Operators**

**Name **|**Description**
-----|-----
$ |Acts as a placeholder to update the first element that matches the query condition in an update.
$addToSet |Adds elements to an array only if they do not already exist in the set.
$pop |Removes the first or last item of an array.
$pullAll |Removes all matching values from an array.
$pull |Removes all array elements that match a specified query.
$pushAll |Deprecated. Adds several items to an array.
$push |Adds an item to an array.

##### **Update Operator Modifiers**

**Name **|**Description**
-----|-----
$each |Modifies the `$push` and `$addToSet` operators to append multiple items for array updates.
$slice |Modifies the `$push` operator to limit the size of updated arrays.
$sort |Modifies the `$push` operator to reorder documents stored in an array.
$position |Modifies the `$push` operator to specify the position in the array to add elements.

### 3.1 - Example : $push
---
Push a review in reviews array : 

	db.movieDetails.updateOne({title: "The Martian"},
	                          {$push: { reviews: { rating: 4.5,
	                                               date: ISODate("2016-01-12T09:00:00Z"),
	                                               reviewer: "Spencer H.",
	                                               text: "The Martian could have been a sad drama film, instead it was a hilarious film with a little bit of drama added to it. The Martian is what everybody wants from a space adventure. Ridley Scott can still make great movies and this is one of his best."} } })

Push several reviews in reviews array : 

	db.movieDetails.updateOne({title: "The Martian"},
	                          {$push: { reviews:
	                                    { $each: [
	                                        { rating: 0.5,
	                                          date: ISODate("2016-01-12T07:00:00Z"),
	                                          reviewer: "Yabo A.",
	                                          text: "i believe its ranked high due to its slogan 'Bring him Home' there is nothing in the movie, nothing at all ! Story telling for fiction story !"},
	                                        { rating: 5,
	                                          date: ISODate("2016-01-12T09:00:00Z"),
	                                          reviewer: "Kristina Z.",
	                                          text: "This is a masterpiece. The ending is quite different from the book - the movie provides a resolution whilst a book doesn't."} ] } } } )

Push several reviews, but at the end it must have 5 elements maximun in the reviews field. This condition is made by `$slice` operator. The operator `$position` is here to push in the first position the element. 

    db.movieDetails.updateOne({ title: "The Martian" },
                              {$push: { reviews:
                                        { $each: [
                                            { rating: 0.5,
                                              date: ISODate("2016-01-13T07:00:00Z"),
                                              reviewer: "Shannon B.",
                                              text: "Enjoyed watching with my kids!" } ],
                                          $position: 0,
                                          $slice: 5 } } } )

### 3.2 - Example : $unset

We could do this, but it's probably the wrong semantics.
	
	db.movieDetails.updateMany( { rated: null },
                            { $set : { rated: "UNRATED" } } )


It is better to do this. It will remove reated to the document where rated is null.

	db.movieDetails.updateMany( { rated: null },
                            { $unset: { rated: "" } } )







