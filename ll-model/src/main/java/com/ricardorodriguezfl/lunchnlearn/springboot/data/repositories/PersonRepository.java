package com.ricardorodriguezfl.lunchnlearn.springboot.data.repositories;


import com.ricardorodriguezfl.lunchnlearn.springboot.data.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * This is the DAO responsible for accessing Person objects, represented by rows in the database
 * 
 * @author Ricardo Rodriguez
 *
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	Person findById(Long id);
	Person findByLastName(String lastName);
	Person findByFirstName(String firstName);

}
