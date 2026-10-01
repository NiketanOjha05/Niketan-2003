package in.com.mongo.config;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

public class UserModel {

	private MongoDatabase database;

	public UserModel() {
		database = MongoDbConnection.getDatabase();

	}

	private int NextId() {
		Document highestIdDoc = database.getCollection("rays").find().sort(Sorts.descending("id")).limit(1).first();

		if (highestIdDoc == null) {
			return 1;

		}
		int highestId = highestIdDoc.getInteger("id");
		return highestId + 1;

	}

	public void add(UserDto user) {
		MongoCollection<Document> collection = database.getCollection("rays");
		int nextId = NextId();
		user.setId(nextId);

		Document doc = new Document("id", user.getId());

		doc.append("id", user.getId());
		doc.append("name", user.getName());
		doc.append("age", user.getAge());
		doc.append("gender", user.getGender());

		collection.insertOne(doc);

		System.out.println("User added successfully");
		System.out.println("User ID : " + nextId);

	}

	public void manyInsert(List<UserDto> users) {

		MongoCollection<Document> collection = database.getCollection("rays");

		List<Document> documents = new ArrayList<>();

		int nextId = NextId();

		for (UserDto user : users) {

			user.setId(nextId++);

			Document doc = new Document();

			doc.append("id", user.getId());
			doc.append("name", user.getName());
			doc.append("gender", user.getGender());
			doc.append("age", user.getAge());

			documents.add(doc);
		}

		collection.insertMany(documents);

		System.out.println(users.size() + " users inserted successfully");
	}

}
