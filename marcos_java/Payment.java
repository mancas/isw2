package domain;

import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;


public class Payment extends DomainEntity{

	private Date moment;
	private Money amount;
	
	
	public Payment()
	{
		this.moment = Calendar.getInstance().getTime();
		this.amount = new Money();
	}
	
	// getters
	
	@NotNull
	@Past
	public Date getMoment()
	{
		return this.moment;
	}
	
	@NotNull
	@Valid
	public Money getAmount()
	{
		return this.amount;
	}
	
	// setters
	
	public void setMoment(Date moment)
	{
		if(moment != null){
			this.moment = moment;
		}
		else{
			System.out.println("Class Payment: cannot set a null moment.");
		}
	}
	
	/*TODO: implement restriction Payment-Certification
	 * 
	 * AMOUNT must be equal to FEE in certification.
	 */
	public void setAmount(Money amount)
	{
		if (amount != null){
			this.amount = amount;
		}
		else{
			System.out.println("Class Payment: cannot set a null amount.");
		}
	}
}
