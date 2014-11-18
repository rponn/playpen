package com.ravi.sampleapp.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.sampleapp.dao.CustomerRepository;
import com.ravi.sampleapp.models.Customer;

@Configuration
@EnableAutoConfiguration
@RestController
public class CustomerController {

	@Autowired 
	CustomerRepository repository;

	private Logger log = Logger.getLogger(CustomerController.class);
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long id) {
        // fetch an individual customer by ID
        Customer customer = repository.findOne(id);
        log.info(customer);
        
        return customer;
    }

    @RequestMapping("/customer/{name}")
    public List<Customer> getCustomerByName(@PathVariable String name) throws Exception{
        // fetch a list of customers by name
    	log.info("Fetching customers by name");
        List<Customer> customers = repository.findByName(name);
        if (customers.size() > 0)
        	return customers;
        throw new Exception("No customers found");
    }
    
    @RequestMapping(value="/customer", method=RequestMethod.POST)
    public Customer updateCustomer(@RequestBody Customer customer) {
    	log.info("Updating customer ...."+customer.getName());
        return repository.save(customer);
        
    }
    
    @RequestMapping(value="/customer", method=RequestMethod.DELETE)
    public void deleteCustomer(@RequestBody Customer customer) {
    	log.info("Deleting customer ....");
        repository.delete(customer);
    }

    @RequestMapping ("/customers")
    public  @ResponseBody Iterable<Customer> getCustomers() {
        // fetch an individual customer by ID
        log.info("Fetching all customers ...");
        return repository.findAll();
    }
	
}