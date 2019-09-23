package br.com.cvc.evaluation.broker.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrokerHotel {

	private Integer id;

	private String name;

	private Integer cityCode;

	private String cityName;

	private List<BrokerHotelRoom> rooms;

	public BrokerHotel() {
		super();
		this.id = 0;
		this.name = "";
		this.cityCode = 0;
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

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<BrokerHotelRoom> getRooms() {
		return rooms;
	}

	public void setRooms(List<BrokerHotelRoom> rooms) {
		this.rooms = rooms;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, cityCode, cityName, rooms);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BrokerHotel other = (BrokerHotel) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(cityCode, other.cityCode) && Objects.equals(cityName, other.cityName)
				&& Objects.equals(rooms, other.rooms);
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
		builder.append(", cityName=");
		builder.append(cityName);
		builder.append(", rooms=");
		builder.append(rooms);
		builder.append("]");
		return builder.toString();
	}

}
