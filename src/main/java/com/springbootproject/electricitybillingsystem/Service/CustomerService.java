package com.springbootproject.electricitybillingsystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.electricitybillingsystem.Repository.*;
import com.springbootproject.electricitybillingsystem.Entities.*;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao CustomerDao;
	@Autowired 
	private MeterDao meterDao;

	public Customer getCustomer(final int id) {
		return CustomerDao.getCustomer(id);
	}
	
	public Customer findByUsername(String username)
	{
		List<Customer> customers = CustomerDao.getCustomers();
		
		for(Customer c : customers)
		{
			if((c.getUsername()).equals(username))
			{
				return c;
			}
		}
		return null;
	}
	
	public Customer findByConsumerNumber(int consumerNumber)
	{
		List<Customer> customers = CustomerDao.getCustomers();
		
		for(Customer c : customers)
		{
			if(c.getConsumerNumber() == consumerNumber)
			{
				return c;
			}
		}
		return null;
	}

	public List<Customer> getCustomers() {
		return CustomerDao.getCustomers();
	}

	public void addCustomer(final Customer Customer) {
		CustomerDao.addCustomer(Customer);
	}

	public void updateCustomer(final Customer Customer) {
		CustomerDao.updateCustomer(Customer);
	}

	public void deleteCustomer(final int id) {
		CustomerDao.deleteCustomer(id);
	}
	
	public List<Meter> getMeters(Customer customer)
	{
		List<Meter> m = meterDao.getMeters();
		String username = customer.getUsername();
		List<Meter> returnList = new ArrayList<Meter>();
		
		for(Meter meter : m)
		{
			if(((meter.getCustomer()).getUsername()).equals(username))
			{
				System.out.println("Added");
				returnList.add(meter);
			}
		}
		return returnList;
	}
}
