package com.springbootproject.electricitybillingsystem.Controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbootproject.electricitybillingsystem.Entities.Customer;
import com.springbootproject.electricitybillingsystem.Entities.Meter;
import com.springbootproject.electricitybillingsystem.Service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@GetMapping("/")
	public String showHome()
	{
		return "Home";
	}
	

	@GetMapping("/addCustomer")
	public String addPage() {
		return "addcustomer";
	}
	@PostMapping("/register")
	public String addCustomer(@RequestParam(value = "firstName", required = true) String firstName, 
			@RequestParam(value = "lastName", required = true) String lastName,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "phoneNumber", required = true) String phoneNumber,
			@RequestParam(value = "consumerNumber", required = true) int consumerNumber,
			@RequestParam(value = "address", required = true) String address,
			@RequestParam(value = "city", required = true) String city,
			@RequestParam(value = "state", required = true) String state,
			@RequestParam(value = "username", required = true) String username, 
			@RequestParam(value = "password", required = true) String password, ModelMap model) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPhoneNumber(phoneNumber);
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		customer.setConsumerNumber(consumerNumber);
		cs.addCustomer(customer);
		String str = "Customer added succesfully";
		model.addAttribute("msg", str);
		return "login";
	}
	
	@GetMapping("/login")
	public String LoginCustomer()
	{
		return "login";
	}
	@PostMapping("/login/customer")
	public String Login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, ModelMap messages,  HttpServletRequest request)
	{
		Customer c = cs.findByUsername(username);
		if(c != null)
		{
			if(c.getPassword().equals(password))
			{
				messages.addAttribute("msg", "Login Successful :)");
				messages.addAttribute("customer", c);
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				Customer cus = cs.findByUsername(username);
				session.setAttribute("consumerNumber", cus.getConsumerNumber());
				messages.addAttribute("msg", "Successfully Logged In   :)");
				return "Home";
			}
		}
		messages.addAttribute("msg", "Incorrect username or password   :(");
		return "login";
	}
	
	@GetMapping("/customers")
	public String getCustomers(ModelMap CustomerModel) {
		List<Customer> Customers = cs.getCustomers();
		CustomerModel.addAttribute("customers", Customers);
		return "customers";
	}
	
	@GetMapping("update/customer/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap customerModel) {
		customerModel.addAttribute("id", id);
		Customer customer = cs.getCustomer(id);
		customerModel.addAttribute("customer", customer);
		return "update";
	}



	@GetMapping("/delete/customer/{id}")
	public String deletecustomer(@PathVariable int id, ModelMap customerModel) {
		cs.deleteCustomer(id);
		List<Customer> customers = cs.getCustomers();
		customerModel.addAttribute("customers", customers);
		customerModel.addAttribute("msg", "customer delted successfully");
		return "redirect:/customers";
	}
	
	@GetMapping("/customer/{id}")
	public String detailsOfCustomer(@PathVariable int id, ModelMap detailModel)
	{
		Customer c = cs.getCustomer(id);
		System.out.println(c);
		detailModel.addAttribute("msg", "Detail of the Customer are : ");
		detailModel.addAttribute("detail", c);
		return "customer";
		
	}
	
	@GetMapping("/logout")
	public String logoutCustomer(HttpServletRequest request, ModelMap messages) {
		messages.addAttribute("msg", "Logout Successfully");
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "Home";
	}
	@GetMapping("/pay")
	public String pay(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		ModelMap details = new ModelMap();
		if(session == null)
		{
			System.out.println("Session null");
			System.out.println("Session null");
			System.out.println("Session null");
			System.out.println("Session null");
			System.out.println("Session null");
			System.out.println("Session null");
			System.out.println("Session null");
			System.out.println("Session null");
			System.out.println("Session null");
		}
		if(session != null)
		{
			Customer customer = cs.findByUsername((String) session.getAttribute("username"));
			details.addAttribute("msg", customer);
		}
		else
		{
			return "redirect:/login";
		}
		return "billing_form";
	}

	@PostMapping("/add/meter")
	public String associateMeterWithCustomer(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "meter_number", required = true) int meter_number)
	{
		System.out.println(username);
		Customer c = cs.findByUsername(username);
		Meter meter = new Meter();
		meter.setMeter_number(meter_number);
		List<Meter> meters = c.getMeters();
		meters.add(meter);
		c.setMeters(meters);
		cs.updateCustomer(c);
		return "redirect:/";
	}
	
	@GetMapping("/renderProfile")
	public String renderProfile(HttpServletRequest request, ModelMap model)
	{
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("username");
		Customer c = cs.findByUsername(username);
		
		List<Meter> meters = c.getMeters();
		if(meters == null)
		{
			return "redirect:/";
		}
		session.setAttribute("found_list", true);
		model.addAttribute("list", meters);
		return "profilePage";
	}
	
	@GetMapping("/payment")
	public String payment(ModelMap messages)
	{
		messages.addAttribute("msg", "Payment Successful");
		return "Home";
				
	}
}
