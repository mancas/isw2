package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.Assert;


@Entity
@Access(AccessType.PROPERTY)
public class OpenAnswer extends Answer{

	private String answer;
	
	public OpenAnswer()
	{
		super();
	}
	
	@NotBlank
	public String getOpenAnswer()
	{
		return this.answer;
	}
	
	public void setOpenAnswer(String answer)
	{
		Assert.notNull(answer);
		assert !answer.isEmpty();
		this.answer = answer;
	}
	
}
