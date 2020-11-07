package me.springframework.mybeerworks.service;

import java.util.UUID;

import me.springframework.mybeerworks.web.model.CustomerDTO;

public interface CustomerService {

	CustomerDTO getCustomerById(UUID customerId);

	CustomerDTO saveNewCustomer(CustomerDTO customerDTO);

	void saveOrUpdateCustomer(UUID customerId, CustomerDTO customerDTO);

	void deleteCustomer(UUID customerId);

}
