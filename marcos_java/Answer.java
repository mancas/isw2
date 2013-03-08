package domain;

import javax.validation.constraints.Min;

public class Answer extends DomainEntity{

	private Double mark;
	
	public Answer()
	{
		this.mark = 0.0;
	}
	
	@Min(0)
	public Double getMark()
	{
		return this.mark;
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
