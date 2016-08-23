package com.mongodb.m101j.crud;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.m101j.util.Helpers.printJson;


public class SecretTest {
    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("students");
        MongoCollection<Document> collection = database.getCollection("grades");

        Bson filter = and(eq("type", "homework"));
        Bson sort = ascending("student_id", "score");


        MongoCursor<Document> cursor = collection.find()
                .filter(filter)
                .sort(sort)
                .iterator();
        int currentStudentId = -1;

        try {
            while (cursor.hasNext()) {
                Document gradeDoc = cursor.next();
                ObjectId _id = gradeDoc.getObjectId("_id");
                int studentId = gradeDoc.getInteger("student_id");

                if(currentStudentId != studentId) {
                    Bson filterDelete = and(eq("_id", _id));
                    collection.deleteOne(filterDelete);
                    currentStudentId = studentId;
                }

            }
        } finally {
            cursor.close();
        }
    }
}