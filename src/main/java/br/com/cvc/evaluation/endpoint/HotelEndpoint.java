package br.com.cvc.evaluation.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.evaluation.endpoint.dto.BookingResponse;

@RestController
@RequestMapping("/hotel")
public class HotelEndpoint {

	@GetMapping("/{id}")
	public BookingResponse find(@PathVariable("id") final Integer id) {

		return new BookingResponse();
	}

}
