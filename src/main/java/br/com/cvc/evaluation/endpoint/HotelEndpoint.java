package br.com.cvc.evaluation.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.evaluation.domain.Hotel;
import br.com.cvc.evaluation.service.BookingService;

@RestController
@RequestMapping("/hotel")
public class HotelEndpoint {

	@Autowired
	private BookingService bookingService;

	@GetMapping("/{id}")
	public Hotel find(@PathVariable("id") final Integer id) {

		return this.bookingService.getHotelDetails(id);
	}

}
