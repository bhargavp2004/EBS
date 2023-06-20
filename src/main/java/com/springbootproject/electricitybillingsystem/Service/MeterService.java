package com.springbootproject.electricitybillingsystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootproject.electricitybillingsystem.Entities.Meter;
import com.springbootproject.electricitybillingsystem.Repository.MeterDao;

@Service
public class MeterService {
	
	@Autowired
	MeterDao meterDao;
	
	public List<Meter> getMeters()
	{
		return meterDao.getMeters();
	}
	public Meter getMeterByMeterNumber(int meter_number)
	{
		Meter meter = meterDao.getMeterByMeterNumber(meter_number);
		return meter;
	}
	public void addMeter(final Meter Meter) {
		meterDao.addMeter(Meter);
	}
	
	public void updateMeter(final Meter Meter) {
		meterDao.updateMeter(Meter);
	}

	public void deleteMeter(final int id) {
		meterDao.deleteMeter(id);
	}
}
