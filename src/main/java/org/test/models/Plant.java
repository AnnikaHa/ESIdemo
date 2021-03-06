package org.test.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;



@Entity
@Data
@XmlRootElement
public class Plant {

	
	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO)
	Long id;

	String name;
	String description;
	Float price;
}
