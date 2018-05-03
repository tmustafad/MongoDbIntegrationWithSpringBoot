package com.turkmen.mongodb.MongoDbIntegrationWithSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.turkmen.mongodb.MongoDbIntegrationWithSpringBoot.entity.Person;
import com.turkmen.mongodb.MongoDbIntegrationWithSpringBoot.repository.PersonRepository;

@SpringBootApplication
public class MongoDbIntegrationWithSpringBootApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoDbIntegrationWithSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personRepository.deleteAll();
		
		// add people to mongo db
		personRepository.save(new Person("Michael","Schumacher"));
		personRepository.save(new Person("Mika","Hakkinen"));
		
		// get all added people and see them in the console
		
		for(Person person:personRepository.findAll()) {
			System.out.println(person);
		}
		
		
	}
}
