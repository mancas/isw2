package domain;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;


@Entity
@Access(AccessType.PROPERTY)
public class Answer extends DomainEntity{

	private int number;
	private Double mark;
	
	public Answer()
	{
		super();
		this.number = 0;
		this.mark = 0.0;
	}
	
	// getters
	
	@Min(0)
	@NotNull
	public int getNumber()
	{
		return this.number;
	}

	@Min(0)
	public Double getMark()
	{
		return this.mark;
	}
	
	// setters
	
	public void setNumber(int number)
	{
		Assert.notNull(number);
		this.number = number;
	}
	
	public void setMark(Double mark)
	{
		Assert.notNull(mark);
		this.mark = mark;
	}
	
}
