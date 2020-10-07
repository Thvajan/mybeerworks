/**
 * 
 */
package me.springframework.mybeerworks.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import me.springframework.mybeerworks.service.CustomerService;
import me.springframework.mybeerworks.web.model.CustomerDTO;

/**
 * @author srive
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID customerId) {
		return CustomerDTO.builder().id(UUID.randomUUID()).name("Raghav").build();
	}

}
