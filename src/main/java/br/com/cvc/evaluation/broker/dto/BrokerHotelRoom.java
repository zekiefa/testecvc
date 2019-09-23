package br.com.cvc.evaluation.broker.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrokerHotelRoom {

	private Integer roomID;

	private String categoryName;

	private Price price;

	public BrokerHotelRoom() {
		super();
		this.roomID = 0;
		this.categoryName = "";
		this.price = new Price();
	}

	public Integer getRoomID() {
		return roomID;
	}

	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryName, price, roomID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BrokerHotelRoom other = (BrokerHotelRoom) obj;
		return Objects.equals(categoryName, other.categoryName) && Objects.equals(price, other.price)
				&& Objects.equals(roomID, other.roomID);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Room [roomID=");
		builder.append(roomID);
		builder.append(", categoryName=");
		builder.append(categoryName);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
}
