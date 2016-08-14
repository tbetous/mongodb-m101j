#Regex operator

### Regex operator documentation
---

All information about regex operator can be found in the official documentation here : https://docs.mongodb.com/manual/reference/operator/query/regex/#op._S_regex

### Example : $regex
--- 

Find movies where text begins with Won :

    db.movieDetails.find({ "awards.text": { $regex: /^Won.*/ } }).pretty()








