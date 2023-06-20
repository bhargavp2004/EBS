
package com.springbootproject.electricitybillingsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springbootproject.electricitybillingsystem.Entities.Reader;
import com.springbootproject.electricitybillingsystem.Service.ReaderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReaderController {
	
	@Autowired
	ReaderService rs;
	
	@GetMapping("/addReader")
	public String addReader()
	{
		return "addReader";
	}
	
	@PostMapping("/add/reader")
	public String registerReader(@RequestParam(value = "firstName", required = true) String firstName, 
			@RequestParam(value = "lastName", required = true) String lastName,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "phoneNumber", required = true) String phoneNumber,
			@RequestParam(value = "address", required = true) String address,
			@RequestParam(value = "city", required = true) String city,
			@RequestParam(value = "state", required = true) String state,
			@RequestParam(value = "username", required = true) String username, 
			@RequestParam(value = "password", required = true) String password, 
			ModelMap ReaderModel)
	{
		Reader reader = new Reader();
		reader.setFirstName(firstName);
		reader.setLastName(lastName);
		reader.setUsername(username);
		reader.setPassword(password);
		reader.setCity(city);
		reader.setAddress(address);
		reader.setState(state);
		reader.setPhoneNumber(phoneNumber);
		reader.setEmail(email);
		rs.addReader(reader);
		ReaderModel.addAttribute("msg", "Reader Added Successfully!");
		return "redirect:/loginReader";
	}
	
	@GetMapping("/loginReader")
	public String LoginCustomer()
	{
		return "loginReader";
	}
	@PostMapping("/login/reader")
	public String loginReader(HttpServletRequest request, ModelMap messages, @RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password)
	{
		Reader r = rs.findByUsername(username);
		if(r != null)
		{
			if(r.getPassword().equals(password))
			{
				messages.addAttribute("msg", "Login Successful :)");
				messages.addAttribute("reader", r);
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				String str = "reader";
				session.setAttribute("type", str);
				return "redirect:/";
			}
		}
		messages.addAttribute("msg", "Incorrect username or password");
		return "redirect:/login";
	}
	
	@GetMapping("/addMeterData")
	public String addMeterData()
	{
		return "meterDataForm";
	}
	
	
}
