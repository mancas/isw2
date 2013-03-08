package domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



public class Answer extends DomainEntity{

	private Integer number;
	private Double mark;
	
	public Answer()
	{
		super();
	}
	
	// getters
	
	@Min(0)
	@NotNull
	public Integer getNumber()
	{
		return this.number;
	}

	@Min(0)
	public Double getMark()
	{
		return this.mark;
	}
	
	// setters
	
	public void setNumber(Integer number)
	{
		this.number = number;
	}
	
	public void setMark(Double mark)
	{
		this.mark = mark;
	}
	
}
