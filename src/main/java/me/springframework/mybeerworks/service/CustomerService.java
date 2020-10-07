package me.springframework.mybeerworks.service;

import java.util.UUID;

import me.springframework.mybeerworks.web.model.CustomerDTO;

public interface CustomerService {

	CustomerDTO getCustomerById(UUID customerId);

}
