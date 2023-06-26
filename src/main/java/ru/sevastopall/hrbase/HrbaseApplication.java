package ru.sevastopall.hrbase;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.model.IndexOptions;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.sevastopall.hrbase.domain.Candidate;
import ru.sevastopall.hrbase.repository.CandidateRepository;

import java.util.Map;

@SpringBootApplication
@EnableMongoRepositories
public class HrbaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(HrbaseApplication.class, args);

/*		System.out.println("Hello");
		try (MongoClient mongoClient = MongoClients.create()) {
			var database = mongoClient.getDatabase("test");
			database.listCollections().forEach(System.out::println);
			var usersCollection = database.getCollection("users");
			usersCollection.listIndexes().forEach(System.out::println);
			usersCollection.createIndex(new Document("name", 1), new IndexOptions().name("idxName"));
			usersCollection.listIndexes().forEach(System.out::println);
			usersCollection.dropIndex("idxName");
			*//*var document = new Document(Map.of("name", "Jake", "company", "Nike"));
			usersCollection.insertOne(document);*//*
			*//*usersCollection.insertOne(new Document(Map.of("name", "Kyle", "salary", 300)));*//*
			usersCollection.find(new Document("name", "Kyle")).forEach(System.out::println);
		}*/
	}

}
