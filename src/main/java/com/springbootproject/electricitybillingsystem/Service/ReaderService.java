package com.springbootproject.electricitybillingsystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.electricitybillingsystem.Entities.Reader;
import com.springbootproject.electricitybillingsystem.Repository.ReaderDao;

@Service
public class ReaderService {
	@Autowired
	private ReaderDao readerDao;
	
	public List<Reader> getReaders() {
		return readerDao.getReaders();
	}
	
	public Reader getReaderByUsername(String username)
	{
		List<Reader> readers = getReaders();
		Reader reader = new Reader();
		for(Reader r : readers)
		{
			if((r.getUsername()).equals(username))
			{
				reader = r;
			}
		}
		return reader;
	}
	

	public void addReader(final Reader reader) {
		readerDao.addReader(reader);
	}

	public void updateReader(final Reader reader) {
		readerDao.updateReader(reader);
	}

	public void deleteReader(final int id) {
		readerDao.deleteReader(id);
	}
	
	public Reader findByUsername(String username)
	{
		List<Reader> readers = getReaders();
		
		for(Reader r : readers)
		{
			if(r.getUsername().equals(username))
			{
				return r;
			}
		}
		return null;
	}
}
