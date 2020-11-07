/**
 * 
 */
package me.springframework.mybeerworks.web.controller;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import me.springframework.mybeerworks.service.BeerService;
import me.springframework.mybeerworks.web.model.BeerDTO;

/**
 * @author srive
 *
 */
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

	private final Logger logger = LogManager.getLogger(BeerController.class);

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
		logger.info("Beer for Id: " + beerId.toString() + " coming right up!");
		return new ResponseEntity<BeerDTO>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	/**
	 * API call to create new beer
	 * 
	 * @param beerDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<BeerDTO> saveNewBeer(@RequestBody BeerDTO beerDTO) {
		BeerDTO result = beerService.saveNewBeer(beerDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer/" + result.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	/**
	 * API call to create new beer
	 * 
	 * @param beerDTO
	 * @return
	 */
	@PutMapping({ "/{beerId}" })
	public ResponseEntity saveOrUpdateBeer(@PathVariable UUID beerId, @RequestBody BeerDTO beerDTO) {
		beerService.saveOrUpdateBeer(beerId, beerDTO);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	/**
	 * API call to delete Beer by UUID
	 * 
	 * @param beerId
	 * @return
	 */
	@DeleteMapping({ "/{beerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerService.deleteBeer(beerId);
	}
}
