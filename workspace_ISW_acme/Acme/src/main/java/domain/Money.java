package domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Money {
	
	private Double amount;
	private String currency;
	
	public Money()
	{
		super();
	}

	@NotNull
	@Min(0)
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@NotBlank
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		assert !currency.isEmpty();
		this.currency = currency;
	}
	
	public Money add(Double money)
	{
		if (this.amount == null) {
			this.amount = 0 + money;
		} else { 
			this.amount += money;
		}
		
		return this;
	}
	
	public Money subtract(Double money)
	{
		if (this.amount > money) {
			this.amount -= money;
		} else {
			throw new IllegalArgumentException("You cannot subtract so much money");
		}
		
		return this;
	}
	
}
