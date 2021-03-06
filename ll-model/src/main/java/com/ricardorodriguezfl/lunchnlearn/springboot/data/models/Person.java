package com.ricardorodriguezfl.lunchnlearn.springboot.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a row from the Persons table
 * 
 * @author Ricardo Rodriguez
 *
 */
@Entity
@Table (name = "Persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	public Person() {}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

    //----------------------------------------------------------------------------------------------------------------
	public Long getId() {
		return id;
	}

    //----------------------------------------------------------------------------------------------------------------
	@JsonProperty(required = false)
	@ApiModelProperty(notes = "Person ID is auto-generated", required = false)
	public void setId(Long id) {
		this.id = id;
	}

    //----------------------------------------------------------------------------------------------------------------
	public String getFirstName() {
		return firstName;
	}

    //----------------------------------------------------------------------------------------------------------------
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The first name of the person", required = true)
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    //----------------------------------------------------------------------------------------------------------------
	public String getLastName() {
		return lastName;
	}

    //----------------------------------------------------------------------------------------------------------------
	@JsonProperty(required = true)
	@ApiModelProperty(notes = "The last name of the person", required = true)
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    //----------------------------------------------------------------------------------------------------------------
	public String toString() {
		return "Person: " + lastName + ", " + firstName;
	}
}
