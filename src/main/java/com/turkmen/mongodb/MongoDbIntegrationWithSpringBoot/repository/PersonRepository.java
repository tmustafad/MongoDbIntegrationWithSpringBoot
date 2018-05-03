/**
 * 
 */
package com.turkmen.mongodb.MongoDbIntegrationWithSpringBoot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.turkmen.mongodb.MongoDbIntegrationWithSpringBoot.entity.Person;

/**
 * @author TTTDEMIRCI
 *
 */

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

	public Person findByName(String name);

	public List<Person> findBySurname(String surname);
}
