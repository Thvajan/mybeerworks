/**
 * 
 */
package me.springframework.mybeerworks.service.impl;

import java.util.UUID;

import me.springframework.mybeerworks.service.BeerService;
import me.springframework.mybeerworks.web.model.BeerDTO;

/**
 * @author srive
 *
 */
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDTO getBeerById(UUID beerId) {
		return BeerDTO.builder().id(UUID.randomUUID()).beerName("Tuborg").beerStyle("Ginger Beer").build();
	}

}
