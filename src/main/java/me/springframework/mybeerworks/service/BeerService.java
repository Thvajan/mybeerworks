package me.springframework.mybeerworks.service;

import java.util.UUID;

import me.springframework.mybeerworks.web.model.BeerDTO;

public interface BeerService {

	BeerDTO getBeerById(UUID beerId);

}