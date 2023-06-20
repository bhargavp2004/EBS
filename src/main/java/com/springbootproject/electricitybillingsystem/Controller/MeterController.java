package com.springbootproject.electricitybillingsystem.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springbootproject.electricitybillingsystem.Entities.Customer;
import com.springbootproject.electricitybillingsystem.Entities.Meter;
import com.springbootproject.electricitybillingsystem.Service.CustomerService;
import com.springbootproject.electricitybillingsystem.Service.MeterService;
import com.springbootproject.electricitybillingsystem.Service.ReaderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MeterController {

	@Autowired
	MeterService ms;

	@Autowired
	CustomerService cs;
	
	@Autowired
	ReaderService rs;

	@GetMapping("/addMeter")
	public String addMeter() {
		return "addMeter";
	}

	@PostMapping("/generateBill")
	public String generateBill(HttpServletRequest request, ModelMap details) {
		int meterNumber = Integer.parseInt(request.getParameter("meter_number"));
		Meter meter = ms.getMeterByMeterNumber(meterNumber);

		if (meter == null) {
			return "redirect:/paybill";
		} else {
			double meterDiff = (meter.getCurrentReading() - meter.getPreviousReading());
			double amount_to_pay = meterDiff * meter.getBillingRate();
			System.out.println(amount_to_pay);
//			String str = Double.toString(amount_to_pay);
			HttpSession session = request.getSession(false);
			session.setAttribute("amount", amount_to_pay);
			session.setAttribute("meterNumber", meterNumber);
		}

		return "redirect:/billShow";
	}

	@GetMapping("/billShow")
	public String billShow(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		int meterNumber = (int) session.getAttribute("meterNumber");
		Meter meter = ms.getMeterByMeterNumber(meterNumber);
		session.setAttribute("currentReading", meter.getCurrentReading());
		session.setAttribute("previousReading", meter.getPreviousReading());
		return "billShow";
	}

	@PostMapping("/addMeterInformation")
	public String addMeterInformation(@RequestParam(value = "consumerNumber", required = true) int consumerNumber, @RequestParam(value = "meter_number", required = true) int meterNumber, @RequestParam(value = "billingRate", required = true) double billingRate, @RequestParam(value = "previousReading", required = true) double previousReading, @RequestParam(value = "currentReading", required = true) double currentReading, HttpServletRequest request)
	{
				Customer customer = cs.findByConsumerNumber(consumerNumber);
				Meter meter = ms.getMeterByMeterNumber(meterNumber);
				
				HttpSession session = request.getSession(false);
				String username = (String)session.getAttribute("username");
				if(meter != null)
				{
					meter.setCustomer(customer);
					meter.setBillingRate(billingRate);
					meter.setPreviousReading(previousReading);
					meter.setCurrentReading(currentReading);
					
					com.springbootproject.electricitybillingsystem.Entities.Reader reader = rs.getReaderByUsername(username);
					meter.setReader(reader);
//					 String pattern = "yyyy-MM-dd"; // Example date format pattern
//
//				        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
//				            Date date = new Date();
//							try {
//								date = dateFormat.parse(dateString);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					meter.setReadingDate(date);
				
					ms.updateMeter(meter);
					
					return "redirect:/";
				}
				

		return "meterDataForm";
	}
	
	@GetMapping("/delete/{meterNumber}")
	public String deleteMeter(@PathVariable(value = "meterNumber", required = true) int meterNumber, ModelMap model)
	{
		Meter meter = ms.getMeterByMeterNumber(meterNumber);
		int id = meter.getMeter_id();
		model.addAttribute("msg", "Deleted Successfully :)");
		
		ms.deleteMeter(id);
		
		return "Home";
	}
}
