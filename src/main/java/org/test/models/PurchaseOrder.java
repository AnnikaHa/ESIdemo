package org.test.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class PurchaseOrder {
	
	@Id
	@GeneratedValue
	Long id;
	
	@OneToOne
	Customer customer;
	
	@OneToOne
	Plant plant;
	
	@Temporal(TemporalType.DATE)
	Calendar startDate;
	
	@Temporal(TemporalType.DATE)
	Calendar endDate;
	
	String contact;
	
	Float cost;
	
	
}
