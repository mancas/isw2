package domain;

import java.util.ArrayList;
import java.util.List;


import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;


public class ExamPaper extends DomainEntity{
	
	private Double mark;
	private Integer score; 
	
	public List<Answer> answers;
	
	
	public ExamPaper()
	{
		super();
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
		this.mark = computeSum(this.answers);
		return this.mark;
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
		this.answers.add(answer);
		/*TODO: TESTEAR
		 * Integer i;

		Registration reg = this.getRegistration();
		Exam exam_reg = reg.getAnnouncement().getExam();

		// get associated question 
		Integer num = answer.getNumber();
		Collection<Question> qs = exam_reg.getQuestions();
		TestQuestion question = null;

		for(Question q: qs){
			if(q.getNumber() == num){
				if(q instanceof TestQuestion){
					question = q;
					break;
				}
			}
		}

		// is in range ?
		if (question.getAnswers().size() >= num)
		{
			this.answer.add(answer);
		}

		 * 
		 */
	}
	
	public void removeAnswer(Answer answer)
	{
		this.answers.remove(answer);
	}
	
	
}
