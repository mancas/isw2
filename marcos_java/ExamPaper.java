package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;
import org.springframework.util.Assert;

@Entity
@Access(AccessType.PROPERTY)
public class ExamPaper extends DomainEntity{
	
	private Double mark;
	private Integer score; 
	
	public List<Answer> answers;
	
	
	public ExamPaper()
	{
		super();
		this.mark = 0.0;
		this.score = 0;
		this.answers = new ArrayList<Answer>();
	}
	
	
	
	private Double computeSum(List<Answer> answers)
	{
		Double sum = 0.0;
		Integer i;
		
		for (i = 0; i < answers.size(); i++){
			sum += answers.get(i).getMark();
		}
		return sum;
	}
	
	// getters
	
	@Min(0)
	public Double getMark()
	{
		return computeSum(this.answers);
	}
	
	@Range(min = 1, max = 99)
	public Integer getScore()
	{
		return this.score;
	}
	
	@Valid
	public List<Answer> getAnswers()
	{
		return this.answers;
	}
	
	
	// setters and modifiers
	
	public void setMark(List<Answer> answers)
	{
		Assert.notNull(answers);
		this.mark = computeSum(answers);
	}
	
	
	public void setScore(Integer score)
	{
		if(score >= 1 || score <= 99){
			this.score = score;
		}
		else{
			System.out.println("Class ExamPaper: Score out of valid range.");
		}
	}
	
	public void addAnswer(Answer answer)
	{
		Assert.notNull(answer);
		this.answers.add(answer);
	}
	
	public void removeAnswer(Answer answer)
	{
		Assert.notNull(answer);
		this.answers.remove(answer);
	}
	
	
}
