package com.ricardorodriguezfl.lunchnlearn.springboot.data.repositories;

import java.util.List;

import com.ricardorodriguezfl.lunchnlearn.springboot.data.LunchNLearnModelApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ricardorodriguezfl.lunchnlearn.springboot.data.models.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LunchNLearnModelApplication.class)
@Transactional
public class TestPersonRepository {
	
	@Autowired
	PersonRepository personRepository;
	
	/** Handle to the log file */
	private final Log log = LogFactory.getLog(getClass());
	
	@Before
	public void initialize() {
		log.info("Set up the " + getClass() + " logging!");
	}
	
	@Test
	public void testFindAll() {
		List<Person> persons = (List<Person>) personRepository.findAll();
		
		Assert.notNull(persons, "Persons object is null!!");
		Assert.notNull(persons, "Persons list is empty!!");
		
		for(Person person : persons) {
			log.info(person);
		}
	}

}
