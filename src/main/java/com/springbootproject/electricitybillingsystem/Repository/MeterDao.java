package com.springbootproject.electricitybillingsystem.Repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootproject.electricitybillingsystem.Entities.Meter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class MeterDao {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Meter> getMeters() {
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		TypedQuery<Meter> theQuery = currentSession.createQuery("from Meter", Meter.class);

		// execute query and get result list
		List<Meter> Meters = theQuery.getResultList();
		currentSession.close();
		
		if(Meters != null)
			return Meters;
		return null;
	}
	
	public Meter getMeter(final int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Meter Meter = currentSession.get(Meter.class, id);
		currentSession.close();
		return Meter;
	}
	
	public Meter getMeterByMeterNumber(int meter_number)
	{
		List<Meter> meters = getMeters();
		
		for(Meter meter : meters)
		{
			if(meter.getMeter_number() == meter_number)
			{
				return meter;
			}
		}
		return null;
	}
	
	@Transactional
	public void addMeter(final Meter Meter) {
		 //get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(Meter);
		currentSession.close();
	}
	@Transactional
	public void updateMeter(Meter meter) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(meter);
		currentSession.close();
	}
	@Transactional
	public void deleteMeter(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Meter Meter = currentSession.get(Meter.class, id);
		currentSession.remove(Meter);
		currentSession.close();
	}
}
