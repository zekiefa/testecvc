package br.com.cvc.evaluation.broker.dto;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

	private BigDecimal adult;

	private BigDecimal child;

	public Price() {
		super();
		this.adult = BigDecimal.ZERO;
		this.child = BigDecimal.ZERO;
	}

	public BigDecimal getAdult() {
		return adult;
	}

	public void setAdult(BigDecimal adult) {
		this.adult = adult;
	}

	public BigDecimal getChild() {
		return child;
	}

	public void setChild(BigDecimal child) {
		this.child = child;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adult, child);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		return Objects.equals(adult, other.adult) && Objects.equals(child, other.child);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Price [adult=");
		builder.append(adult);
		builder.append(", child=");
		builder.append(child);
		builder.append("]");
		return builder.toString();
	}

}
