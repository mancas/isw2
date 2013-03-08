package domain;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Payment extends DomainEntity{

	private String method;
	private Money amount;
	private Registration register;
	
	
	public Payment()
	{
		super();
		this.amount = new Money();
		this.register = new Registration();
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
	
	@NotEmpty
	public Registration getRegister()
	{
		return this.register;
	}
	
	// setters
	
	public void setMethod(String method)
	{
		this.method = method;
	}
	
	public void setRegister(Registration register)
	{
		if (register != null) {
			this.register = register;
			register.setPayment(this);
		} else { 
			throw new IllegalArgumentException("Registration cannot be null");
		}
	}
	
	public void setAmount(Money amount)
	{
		Double certifiationFee = this.register.getAnnouncement().getExam().getCertification().getFee();
		
		if (amount.getAmount() != certifiationFee) {
			throw new IllegalArgumentException("Payment amount must be the same as Certification amount");
		} else {
			this.amount = amount;
		}
	}
}
