package br.com.cvc.evaluation.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.evaluation.endpoint.dto.BookingResponse;

@RestController
@RequestMapping("/booking")
public class BookingEndpoint {

	@GetMapping("/{cityCode}/{checkin}/{checkout}/{checkout}/{adults}/{children}")
	public BookingResponse find(@PathVariable("cityCode") final Integer cityCode,
			@PathVariable("checkin") final String checkin, @PathVariable("checkout") final String checkout,
			@PathVariable("adults") final Integer adults, @PathVariable("children") final Integer children) {

		return new BookingResponse();
	}
}
