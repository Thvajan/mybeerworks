package me.springframework.mybeerworks.service;

import java.util.UUID;

import me.springframework.mybeerworks.web.model.BeerDTO;

public interface BeerService {

	BeerDTO getBeerById(UUID beerId);

	BeerDTO saveNewBeer(BeerDTO beerDTO);

	void saveOrUpdateBeer(UUID beerId, BeerDTO beerDTO);

	void deleteBeer(UUID beerId);

}
