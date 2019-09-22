package br.com.cvc.evaluation.endpoint.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookingResponse {

	private Integer id;

	private String cityName;

	private List<Room> rooms;

	public BookingResponse() {
		super();
		this.id = 0;
		this.cityName = "";
		this.rooms = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityName, id, rooms);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingResponse other = (BookingResponse) obj;
		return Objects.equals(cityName, other.cityName) && Objects.equals(id, other.id)
				&& Objects.equals(rooms, other.rooms);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookingResponse [id=");
		builder.append(id);
		builder.append(", cityName=");
		builder.append(cityName);
		builder.append(", rooms=");
		builder.append(rooms);
		builder.append("]");
		return builder.toString();
	}

}
