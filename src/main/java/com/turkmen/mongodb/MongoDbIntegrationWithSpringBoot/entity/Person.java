/**
 * 
 */
package com.turkmen.mongodb.MongoDbIntegrationWithSpringBoot.entity;

/**
 * @author TTTDEMIRCI
 *
 */
public class Person {

	public String id;

	public String name;
	public String surname;

	public Person() {

	}

	public Person(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	@Override
	public String toString() {

		return " ID : " + this.id + " - Name: " + this.name + " - Surname: " + this.surname;
	}

}
