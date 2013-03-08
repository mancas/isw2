package domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Answer extends DomainEntity{

	private int number;
	private Double mark;
	
	public Answer()
	{
		this.number = 0;
		this.mark = 0.0;
	}
	
	// getters
	
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
		if(number >= 0){
			this.number = number;
		}
		else{
			System.out.println("Class Answer: cannot set a negative 'answer' number");
		}
	}
	
	public void setMark(Double mark)
	{
		if(mark >= 0.0){
			this.mark = mark;
		}
		else{
			System.out.println("Class Answer: Cannot set a negative mark");
		}
	}
	
}
