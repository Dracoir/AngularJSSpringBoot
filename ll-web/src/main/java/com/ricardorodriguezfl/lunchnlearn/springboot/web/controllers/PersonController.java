package com.ricardorodriguezfl.lunchnlearn.springboot.web.controllers;

import java.util.List;

import com.ricardorodriguezfl.lunchnlearn.springboot.data.models.Person;
import com.ricardorodriguezfl.lunchnlearn.springboot.data.services.PersonService;
import io.swagger.annotations.*;
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

    //----------------------------------------------------------------------------------------------------------------
	/**
	 * Default method when accessing /people_rest
	 * @return List&lt;Person&gt;
	 */
	@ApiOperation(value = "getPeople", nickname = "getPeople")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Person.class, responseContainer = "List"),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> getPeople() {
		return personService.getAllPersons();
	}

    //----------------------------------------------------------------------------------------------------------------
	/**
	 * Returns a specific Person object
	 * @param id Long representing the Person ID
     * @return {@link Person}
	 */
	@ApiOperation(value = "getPeople", nickname = "getPeople")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "User's database ID ", required = true, dataType = "string", paramType = "path", defaultValue="-1")
	})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Person.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable("id") Long id) {
		return personService.getPersonById(id);
	}

    //----------------------------------------------------------------------------------------------------------------
	/**
	 * Updates Person data to a row in the database, via the respective service object
	 * @param id Long representing the Person ID
	 * @param firstName String representing the Person first name
	 * @param lastName String representing the Person last name
     * @return {@link Person}
	 */
    @ApiOperation(value = "updatePerson", nickname = "updatePerson")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "User's database ID ", required = true, dataType = "string", paramType = "path", defaultValue="-1"),
            @ApiImplicitParam(name = "firstName", value = "User's first name ", required = true, dataType = "string", paramType = "path", defaultValue="First Name"),
            @ApiImplicitParam(name = "lastName", value = "User's last name ", required = true, dataType = "string", paramType = "path", defaultValue="Last Name")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(value = "/update/{id}/{firstName}/{lastName}", method = RequestMethod.POST)
	public Person updatePerson(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastName) {
		Person person = new Person(firstName, lastName);
		person.setId(id);
		return personService.savePerson(person);
	}

    //----------------------------------------------------------------------------------------------------------------
    /**
     * Saves a new person entry
     * @param firstName String representing the Person first name
     * @param lastName String representing the Person last name
     * @return {@link Person}
     */
    @ApiOperation(value = "savePerson", nickname = "savePerson")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "firstName", value = "User's first name ", required = true, dataType = "string", paramType = "path", defaultValue="First Name"),
            @ApiImplicitParam(name = "lastName", value = "User's last name ", required = true, dataType = "string", paramType = "path", defaultValue="Last Name")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/save/{firstName}/{lastName}", method = RequestMethod.POST)
    public Person savePerson(@PathVariable String firstName, @PathVariable String lastName) {
        Person person = new Person(firstName, lastName);
        return personService.savePerson(person);
    }

    //----------------------------------------------------------------------------------------------------------------
    /**
	 * Deletes a Person from the Person database
	 * @param id Long representing the Person to delete
	 */
    @ApiOperation(value = "deletePerson", nickname = "deletePerson")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "User's database ID ", required = true, dataType = "Long", paramType = "path", defaultValue="-1")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void deletePerson(@PathVariable Long id) {
		personService.deletePersonById(id);
	}

    //----------------------------------------------------------------------------------------------------------------
	/**
	 * Initializes the PersonService member variable for this controller
	 * @param personService
	 */
	@Autowired
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
