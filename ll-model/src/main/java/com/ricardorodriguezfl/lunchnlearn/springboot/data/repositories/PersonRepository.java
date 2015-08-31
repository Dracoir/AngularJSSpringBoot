package com.ricardorodriguezfl.lunchnlearn.springboot.data.repositories;


import com.ricardorodriguezfl.lunchnlearn.springboot.data.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This is the DAO responsible for accessing Person objects, represented by rows in the database
 * 
 * @author Ricardo Rodriguez
 *
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	public Person findById(Long id);
	public Person findByLastName(String lastName);
	public Person findByFirstName(String firstName);
	
}
