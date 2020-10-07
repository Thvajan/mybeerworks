/**
 * 
 */
package me.springframework.mybeerworks.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.springframework.mybeerworks.service.BeerService;
import me.springframework.mybeerworks.web.model.BeerDTO;

/**
 * @author srive
 *
 */
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

	private final BeerService beerService;

	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	/**
	 * API call to get Beer by UUID
	 * 
	 * @param beerId
	 * @return
	 */
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDTO> getBeer(@PathVariable UUID beerId) {
		return new ResponseEntity<BeerDTO>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	/**
	 * API call to create new beer
	 * 
	 * @param beerDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<BeerDTO> saveNewBeer(BeerDTO beerDTO) {
		BeerDTO result = beerService.saveNewBeer(beerDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer/" + result.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

}
