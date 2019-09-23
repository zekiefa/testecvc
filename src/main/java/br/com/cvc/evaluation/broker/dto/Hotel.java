package br.com.cvc.evaluation.broker.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel {

	private Integer id;

	private String name;

	private Integer cityCode;

	private List<Room> rooms;

	public Hotel() {
		super();
		this.id = 0;
		this.name = "";
		this.cityCode = 0;
		this.rooms = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityCode, id, name, rooms);
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
		return Objects.equals(cityCode, other.cityCode) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(rooms, other.rooms);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hotel [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", cityCode=");
		builder.append(cityCode);
		builder.append(", rooms=");
		builder.append(rooms);
		builder.append("]");
		return builder.toString();
	}

}
