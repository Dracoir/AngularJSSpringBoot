package com.ricardorodriguezfl.lunchnlearn.springboot.data.services;

import java.util.List;

import com.ricardorodriguezfl.lunchnlearn.springboot.data.models.Person;
import com.ricardorodriguezfl.lunchnlearn.springboot.data.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Executes business logic on the data needed from and to the database
 * 
 * @author Ricardo Rodriguez
 */
@Service
public class PersonService {

	private PersonRepository personRepository;

	/** 
	 * Return all Persons in the database
	 * 
	 * @return List&lt;Person&gt;
	 */
	public List<Person> getAllPersons() {
		return (List<Person>)personRepository.findAll();
	}
	
	/**
	 * Return person 
	 * @param personId Long representing the row of the person in the database
	 * @return Person
	 */
	public Person getPersonById(Long personId) {
		return personRepository.findById(personId);
	}
	
	/**
	 * Save a person to the database 
	 * @param person Person representing the object to save
	 * @return Person representing the object saved
	 */
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	/**
	 * Delete a person from the database
	 * @param person
	 */
	public void deletePerson(Person person) {
		personRepository.delete(person);
	}
	
	/**
	 * Delete a person from the database
	 * @param personId Long representing the row of the person to delete
	 */
	public void deletePersonById(Long personId) {
		personRepository.delete(personId);
	}
	
	@Autowired
	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
}
