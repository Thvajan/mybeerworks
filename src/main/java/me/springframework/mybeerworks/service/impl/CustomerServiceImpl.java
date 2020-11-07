/**
 * 
 */
package me.springframework.mybeerworks.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.springframework.mybeerworks.service.CustomerService;
import me.springframework.mybeerworks.web.model.CustomerDTO;

/**
 * @author srive
 *
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID customerId) {
		return CustomerDTO.builder().id(UUID.randomUUID()).name("Raghav").build();
	}

	@Override
	public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
		return CustomerDTO.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void saveOrUpdateCustomer(UUID customerId, CustomerDTO customerDTO) {
		log.debug("Customer " + customerId.toString() + " updated successfully");
	}

	@Override
	public void deleteCustomer(UUID customerId) {
		log.debug("Customer " + customerId.toString() + " removed successfully");

	}

}
