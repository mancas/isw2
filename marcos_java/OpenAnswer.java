package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;


@Entity
@Access(AccessType.PROPERTY)
public class OpenAnswer extends Answer{

	private String answer;
	
	public OpenAnswer()
	{
		super();
		this.answer = "answer";
	}
	
	public String getOpenAnswer()
	{
		return this.answer;
	}
	
	public void setOpenAnswer(String answer)
	{
		this.answer = answer;
	}
	
}
