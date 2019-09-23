package br.com.cvc.evaluation.broker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cvc.evaluation.broker.dto.Hotel;

@Service
public class BrokerService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${broker.hotels.endpoint}")
	private String hotelsEndpoint;

	@Value("${broker.hotel.details.endpoint}")
	private String hotelDetailsEndpoint;

	public List<Hotel> findHotelsByCity(final Integer codeCity) {
		ResponseEntity<List<Hotel>> response = this.restTemplate.exchange(
				this.hotelsEndpoint.concat(codeCity.toString()), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Hotel>>() {
				});

		return response.getBody();
	}

	public Hotel getHotelDetails(final Integer codeHotel) {
		ResponseEntity<Hotel> response = this.restTemplate.exchange(
				this.hotelDetailsEndpoint.concat(codeHotel.toString()), HttpMethod.GET, null,
				new ParameterizedTypeReference<Hotel>() {
				});

		return response.getBody();
	}

}
