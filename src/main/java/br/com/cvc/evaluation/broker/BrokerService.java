package br.com.cvc.evaluation.broker;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cvc.evaluation.broker.dto.BrokerHotel;

@Service
public class BrokerService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${broker.hotels.endpoint}")
	private String hotelsEndpoint;

	@Value("${broker.hotel.details.endpoint}")
	private String hotelDetailsEndpoint;

	public List<BrokerHotel> findHotelsByCity(final Integer codeCity) {
		BrokerHotel[] response = this.restTemplate.getForObject(this.hotelsEndpoint.concat(codeCity.toString()),
				BrokerHotel[].class);

		return Arrays.asList(response);
	}

	public BrokerHotel getHotelDetails(final Integer codeHotel) {
		BrokerHotel brokerHotel = new BrokerHotel();
		BrokerHotel[] response = this.restTemplate.getForObject(this.hotelDetailsEndpoint.concat(codeHotel.toString()),
				BrokerHotel[].class);

		if (response.length > 0) {
			brokerHotel = response[0];
		}

		return brokerHotel;
	}

}
