# mongodb-beginner


access container ==> docker exec -it <container> bash

inside the container, access mongosh ==> mongosh mongodb://localhost:27017 -u root -p root


## DB
show dbs
create db ==> use <db_name>

db.help()
db.getName()

db.dropDatabase()


## Collection
db.createCollection("<collection_name>")
show collections
db.collection.drop()

paste BSON, then:
db.<collection>.insertOne({document}/variable)
db.<collection>.insertMany([array-of-documents])

db.<collection>.countDocuments()


## Find method
db.<collection>.find({<criteria>}, {<projection>}).pretty()

"projection" is what I want to return
1 - to return
0 - not to return

Ex:
db.student.find({name: 'ph'}, {age: 1})

## Update
db.student.update({_id: ObjectId('662af403d397eae14fc934df')}, {$set: {name: "ph2}})

db.student.update({_id: ObjectId('662af403d397eae14fc934df')}, {$unset: {age: 1}})


## Delete document
db.student.deleteOne({<document-id>})

if empty, will delete one document

db.student.deleteMany({age: 22})

if empty, will delete all documents

https://www.youtube.com/watch?v=c2M-rlkkT5o&ab_channel=BroCode