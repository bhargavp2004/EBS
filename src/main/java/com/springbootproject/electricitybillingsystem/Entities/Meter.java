package com.springbootproject.electricitybillingsystem.Entities;

import java.util.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Meter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int meter_id;
	private int meter_number;
	private double billingRate;
	private double previousReading;
	private double currentReading;
	private Date readingDate;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "reader_id", referencedColumnName = "id")
	private Reader reader;

	public Meter() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getMeter_id() {
		return meter_id;
	}


	public void setMeter_id(int meter_id) {
		this.meter_id = meter_id;
	}


	public Meter(int meter_number, double billingRate, double previousReading, double currentReading, Date readingDate,
			Customer customer, Reader reader) {
		super();
		this.meter_number = meter_number;
		this.billingRate = billingRate;
		this.previousReading = previousReading;
		this.currentReading = currentReading;
		this.readingDate = readingDate;
		this.customer = customer;
		this.reader = reader;
	}

	public int getMeter_number() {
		return meter_number;
	}

	public void setMeter_number(int meter_number) {
		this.meter_number = meter_number;
	}

	public double getBillingRate() {
		return billingRate;
	}

	public void setBillingRate(double billingRate) {
		this.billingRate = billingRate;
	}

	public double getPreviousReading() {
		return previousReading;
	}

	public void setPreviousReading(double previousReading) {
		this.previousReading = previousReading;
	}

	public double getCurrentReading() {
		return currentReading;
	}

	public void setCurrentReading(double currentReading) {
		this.currentReading = currentReading;
	}

	public Date getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(java.util.Date date) {
		this.readingDate = date;
	}

	 public Customer getCustomer() {
	        // implementation to return a valid Customer object
	        // if customer is not null, otherwise return null
	        return customer != null ? customer : new Customer();
	    }

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	@Override
	public String toString() {
		return "Meter [meter_number=" + meter_number + ", billingRate=" + billingRate + ", previousReading="
				+ previousReading + ", currentReading=" + currentReading + ", readingDate=" + readingDate
				+ "]";
	}
}
