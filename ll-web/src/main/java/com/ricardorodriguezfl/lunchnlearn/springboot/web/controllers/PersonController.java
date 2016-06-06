package com.ricardorodriguezfl.lunchnlearn.springboot.web.controllers;

import java.util.List;

import com.ricardorodriguezfl.lunchnlearn.springboot.data.models.Person;
import com.ricardorodriguezfl.lunchnlearn.springboot.data.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manages all the endpoints for this sample application
 *  
 * @author Ricardo Rodriguez
 *
 */
@RestController
@RequestMapping("/person")
public class PersonController {

	private PersonService personService;
	
	/**
	 * Default method when accessing /people_rest
	 * @return List&lt;Person&gt;
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> getPeople() {
		return personService.getAllPersons();
	}

	/**
	 * Returns a specific Person object
	 * @param id Long representing the Person ID
	 * @return Person
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable("id") Long id) {
		return personService.getPersonById(id);
	}

	/**
	 * Saves Person data to a row in the database, via the respective service object
	 * @param id Long representing the Person ID
	 * @param firstName String representing the Person first name
	 * @param lastName String representing the Person last name
	 */
	@RequestMapping(value = "/save/{id}/{firstName}/{lastName}", method = RequestMethod.POST)
	public void setSavePerson(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastName) {
		Person person = new Person(firstName, lastName);
		person.setId(id);
		personService.savePerson(person);
	}

	/**
	 * Deletes a Person from the Person database
	 * @param id Long representing the Person to delete
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void deletePerson(@PathVariable Long id) {
		personService.deletePersonById(id);
	}

	/**
	 * Initializes the PersonService member variable for this controller
	 * @param personService
	 */
	@Autowired
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
