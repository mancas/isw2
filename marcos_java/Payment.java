package domain;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.Assert;

public class Payment extends DomainEntity{

	private String method;
	private Money amount;
	
	
	public Payment()
	{
		super();
		this.method = "payment method";
		this.amount = new Money();
	}
	
	// getters
	
	@NotNull
	@NotBlank
	public String getMethod()
	{
		return this.method;
	}
	
	@NotNull
	@Valid
	public Money getAmount()
	{
		return this.amount;
	}
	
	// setters
	
	public void setMethod(String method)
	{
		Assert.notNull(method);
		this.method = method;
	}
	
	/*TODO: implement restriction Payment-Certification
	 * 
	 * AMOUNT must be equal to FEE in certification.
	 */
	public void setAmount(Money amount)
	{
		Assert.notNull(amount);
		this.amount = amount;
	}
}
