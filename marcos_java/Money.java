package domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.Assert;

@Embeddable
public class Money {
	
	private Double amount;
	private String currency;
	
	public Money()
	{
		super();
	}

	@NotNull
	@Min(0)
	public Double getamount() {
		return amount;
	}

	public void setamount(Double amount) {
		Assert.notNull(amount);
		this.amount = amount;
	}

	@NotBlank
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		Assert.notNull(currency);
		assert !currency.isEmpty();
		this.currency = currency;
	}
	
	public Money add(Double money)
	{
		Assert.notNull(money);
		this.amount += money;
		
		return this;
	}
	
	public Money subtract(Double money)
	{
		Assert.notNull(money);
		if (this.amount > money) {
			this.amount -= money;
		} else {
			throw new IllegalArgumentException("You cannot subtract so much money");
		}
		
		return this;
	}
	
}
