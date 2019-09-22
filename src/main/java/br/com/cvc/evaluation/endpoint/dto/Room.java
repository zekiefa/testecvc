package br.com.cvc.evaluation.endpoint.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Room {

	private Integer roomID;

	private String categoryName;

	private BigDecimal totalPrice;

	private PriceDetail priceDetail;

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

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public PriceDetail getPriceDetail() {
		return priceDetail;
	}

	public void setPriceDetail(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryName, priceDetail, roomID, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(categoryName, other.categoryName) && Objects.equals(priceDetail, other.priceDetail)
				&& Objects.equals(roomID, other.roomID) && Objects.equals(totalPrice, other.totalPrice);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Room [roomID=");
		builder.append(roomID);
		builder.append(", categoryName=");
		builder.append(categoryName);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", priceDetail=");
		builder.append(priceDetail);
		builder.append("]");
		return builder.toString();
	}

}
