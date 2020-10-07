/**
 * 
 */
package me.springframework.mybeerworks.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author srive
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SuppressWarnings(value = {})
public class BeerDTO {

	private UUID id;
	private String beerName;
	private String beerStyle;
	private Long upc;

}
