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
		this.register = register;
		if (register.getPayment() != this || register.getPayment() == null) {
			register.setPayment(this);
		}
	}
	
	public void setAmount(Money amount)
	{
		this.amount = amount;
		Double certifiationFee = this.register.getAnnouncement().getExam().getCertification().getFee();
		
		if (!this.amount.getAmount().equals(certifiationFee)) {
			throw new IllegalArgumentException("Payment amount must be the same as Certification amount");
		}
	}
}
