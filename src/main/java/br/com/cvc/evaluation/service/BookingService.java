package br.com.cvc.evaluation.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.evaluation.broker.BrokerService;
import br.com.cvc.evaluation.broker.dto.BrokerHotel;
import br.com.cvc.evaluation.broker.dto.BrokerHotelRoom;
import br.com.cvc.evaluation.domain.Hotel;
import br.com.cvc.evaluation.domain.Room;

@Service
public class BookingService {

	private static final Long ONE_DAY = Long.valueOf("1");
	private static final Integer ONE_PAX = 1;

	@Autowired
	private BrokerService brokerService;

	@Autowired
	private FeeService feeService;

	private BigDecimal calculateTotalPrice(final BigDecimal paxPrice, final Long days) {
		final BigDecimal fee = this.feeService.calculateFee(paxPrice, days);

		return paxPrice.add(fee).multiply(BigDecimal.valueOf(days));
	}

	private Long calculatePeriod(final LocalDate checkin, final LocalDate checkout) {
		return checkin.until(checkout, ChronoUnit.DAYS);
	}

	private Room calculateTotalPrice(final BrokerHotelRoom brokerHotelRoom, final Long days, final Integer adults,
			final Integer child) {
		final Room room = new Room();
		BigDecimal totalPrice = BigDecimal.ZERO;

		room.setCategoryName(brokerHotelRoom.getCategoryName());
		room.setRoomID(brokerHotelRoom.getRoomID());

		if (adults > 0) {
			room.getPriceDetail()
					.setPricePerDayAdult(this.calculateTotalPrice(brokerHotelRoom.getPrice().getAdult(), ONE_DAY));
			totalPrice = totalPrice.add(room.getPriceDetail().getPricePerDayAdult().multiply(BigDecimal.valueOf(days)));
		}

		if (child > 0) {
			room.getPriceDetail()
					.setPricePerDayChild(this.calculateTotalPrice(brokerHotelRoom.getPrice().getChild(), ONE_DAY));
			totalPrice = totalPrice.add(room.getPriceDetail().getPricePerDayChild().multiply(BigDecimal.valueOf(days)));
		}

		room.setTotalPrice(totalPrice);

		return room;
	}

	private Hotel calculateBooking(final BrokerHotel brokerHotel, final Long days, final Integer adults,
			final Integer child) {
		final Hotel hotel = new Hotel();

		hotel.setId(brokerHotel.getId());
		hotel.setName(brokerHotel.getName());
		hotel.setCityName(brokerHotel.getCityName());

		hotel.setRooms(brokerHotel.getRooms().stream()
				.map(brokerHotelRoom -> this.calculateTotalPrice(brokerHotelRoom, days, adults, child))
				.collect(Collectors.toList()));

		return hotel;
	}

	public Hotel getHotelDetails(final Integer codeHotel) {
		BrokerHotel hotelDetails = this.brokerService.getHotelDetails(codeHotel);

		return this.calculateBooking(hotelDetails, ONE_DAY, ONE_PAX, ONE_PAX);
	}

	public List<Hotel> findHotels(final Integer cityCode, final LocalDate checkin, final LocalDate checkout,
			final Integer adults, final Integer child) {

		List<BrokerHotel> hotels = this.brokerService.findHotelsByCity(cityCode);
		final Long period = this.calculatePeriod(checkin, checkout);

		return hotels.stream().map(brokerHotel -> this.calculateBooking(brokerHotel, period, adults, child))
				.collect(Collectors.toList());

	}

}
