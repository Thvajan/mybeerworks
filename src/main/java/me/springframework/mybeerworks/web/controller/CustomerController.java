/**
 * 
 */
package me.springframework.mybeerworks.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.springframework.mybeerworks.service.CustomerService;
import me.springframework.mybeerworks.web.model.CustomerDTO;

/**
 * @author srive
 *
 */
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID customerId) {
		return new ResponseEntity<CustomerDTO>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CustomerDTO> saveNewCustomer(@RequestBody CustomerDTO customerDTO) {
		CustomerDTO newCustomer = customerService.saveNewCustomer(customerDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer" + newCustomer.getId());
		ResponseEntity<CustomerDTO> responseEntity = new ResponseEntity<CustomerDTO>(headers, HttpStatus.CREATED);
		return responseEntity;
	}

	@PutMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void saveOrUpdateCustomer(@PathVariable UUID customerId, @RequestBody CustomerDTO customerDTO) {
		customerService.saveOrUpdateCustomer(customerId, customerDTO);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable UUID customerId) {
		customerService.deleteCustomer(customerId);
	}

}
