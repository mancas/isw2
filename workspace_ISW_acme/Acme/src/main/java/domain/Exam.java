package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


public class Exam extends DomainEntity {
	
	private String title;
	private Double minimumMark;
	private Integer minimumScore;
	private Collection<Question> questions;
	private Certification certification;

	public Exam()
	{
		super();

		this.questions = new HashSet<Question>();
	}

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Min(0)
	public Double getMinimumMark() {
		return minimumMark;
	}

	public void setMinimumMark(Double minimumMark) {
		this.minimumMark = minimumMark;
	}

	@Range(min=0, max=99)
	public Integer getMinimumScore() {
		return minimumScore;
	}

	public void setMinimumScore(Integer minimumScore) {
		this.minimumScore = minimumScore;
	}

	@NotEmpty
	public Collection<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(HashSet<Question> questions) {
		assert questions != null;

		this.questions = questions;
	}
	
	public void addQuestion(Question question)
	{
		this.questions.add(question);
		if (!question.getExams().contains(this)) {
			question.addExam(this);
		}
	}
	
	public void removeQuestion(Question question)
	{
		this.questions.remove(question);
		question.removeExam(this);
	}
	
	public Certification getCertification() {
		return certification;
	}

	public void setCertification(Certification certification) {
		assert certification != null;

		this.certification = certification;
		
		if (!certification.getExams().contains(this)) {
			certification.addExam(this);
		}
	}

}
