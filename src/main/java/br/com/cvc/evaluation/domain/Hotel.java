package br.com.cvc.evaluation.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel {

	private Integer id;

	private String cityName;

	private String name;

	private List<Room> rooms;

	public Hotel() {
		super();
		this.id = 0;
		this.name = "";
		this.cityName = "";
		this.rooms = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return Objects.hash(cityName, name, id, rooms);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(cityName, other.cityName) && Objects.equals(id, other.id)
				&& Objects.deepEquals(name, other.name) && Objects.equals(rooms, other.rooms);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookingResponse [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", cityName=");
		builder.append(cityName);
		builder.append(", rooms=");
		builder.append(rooms);
		builder.append("]");
		return builder.toString();
	}

}
