package br.com.cvc.evaluation.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class PriceDetail {

	private BigDecimal pricePerDayAdult;

	private BigDecimal pricePerDayChild;

	public PriceDetail() {
		super();
		this.pricePerDayAdult = BigDecimal.ZERO;
		this.pricePerDayChild = BigDecimal.ZERO;
	}

	public BigDecimal getPricePerDayAdult() {
		return pricePerDayAdult;
	}

	public void setPricePerDayAdult(BigDecimal pricePerDayAdult) {
		this.pricePerDayAdult = pricePerDayAdult;
	}

	public BigDecimal getPricePerDayChild() {
		return pricePerDayChild;
	}

	public void setPricePerDayChild(BigDecimal pricePerDayChild) {
		this.pricePerDayChild = pricePerDayChild;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pricePerDayAdult, pricePerDayChild);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceDetail other = (PriceDetail) obj;
		return Objects.equals(pricePerDayAdult, other.pricePerDayAdult)
				&& Objects.equals(pricePerDayChild, other.pricePerDayChild);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PriceDetail [pricePerDayAdult=");
		builder.append(pricePerDayAdult);
		builder.append(", pricePerDayChild=");
		builder.append(pricePerDayChild);
		builder.append("]");
		return builder.toString();
	}
}
