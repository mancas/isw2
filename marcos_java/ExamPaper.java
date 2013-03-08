package domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;

public class ExamPaper extends DomainEntity{
	
	private Double mark;
	private Integer score; 
	
	public List<Answer> answers;
	
	
	public ExamPaper()
	{
		this.mark = 0.0;
		this.score = 0;
		this.answers = new ArrayList<Answer>();
	}
	
	// getters
	
	@Min(0)
	public Double getMark()
	{
		return this.mark;
	}
	
	@Range(min = 1, max = 99)
	public Integer getScore()
	{
		return this.score;
	}
	
	// setters
	
	public void setMark(Double mark)
	{
		if(mark >= 0.0){
			this.mark = mark;
		}
		else{
			System.out.println("Class ExamPaper: Cannot set a negative mark");
		}
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
	
	
	
	
	
}
