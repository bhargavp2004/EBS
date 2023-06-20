package com.springbootproject.electricitybillingsystem.Repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootproject.electricitybillingsystem.Entities.Reader;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ReaderDao {
	@Autowired
	private EntityManager entityManager;

	public Reader getReader(int id)
	{
		List<Reader> readers = getReaders();
		for(Reader r : readers)
		{
			if(r.getId() == id)
			{
				return r;
			}
		}
		return null;
	}
	
	public List<Reader> getReaders() {
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		TypedQuery<Reader> theQuery = currentSession.createQuery("from Reader", Reader.class);

		// execute query and get result list
		List<Reader> readers = theQuery.getResultList();
		currentSession.close();
		return readers;
	}
	
	@Transactional
	public void addReader(final Reader Reader) {
		 //get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(Reader);
		currentSession.close();
	}

	@Transactional
	public void updateReader(final Reader Reader) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(Reader);
		currentSession.close();
	}

	@Transactional
	public void deleteReader(final int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Reader Reader = currentSession.get(Reader.class, id);
		currentSession.remove(Reader);
		currentSession.close();
	}
	
}
