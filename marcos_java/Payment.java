package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.Assert;

@Entity
@Access(AccessType.PROPERTY)
public class Payment extends DomainEntity{

	private String method;
	private Money amount;
	
	
	public Payment()
	{
		super();
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
