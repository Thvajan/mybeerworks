/**
 * 
 */
package me.springframework.mybeerworks.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.springframework.mybeerworks.service.BeerService;
import me.springframework.mybeerworks.web.model.BeerDTO;

/**
 * @author srive
 *
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDTO getBeerById(UUID beerId) {
		return BeerDTO.builder().id(UUID.randomUUID()).beerName("Tuborg").beerStyle("Ginger Beer").build();
	}

	@Override
	public BeerDTO saveNewBeer(BeerDTO beerDTO) {
		return BeerDTO.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void saveOrUpdateBeer(UUID beerId, BeerDTO beerDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBeer(UUID beerId) {
		log.debug("Deleting a Beer..." + beerId.toString());
	}

}
