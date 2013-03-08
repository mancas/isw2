package domain;

import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.Assert;


@Entity
@Access(AccessType.PROPERTY)
public abstract class Question extends DomainEntity {
	
	private Integer number;
	private String statement;
	private Double maximunMark;
	private HashSet<Exam> exams;
	
	public Question()
	{
		super();
		this.exams = new HashSet<Exam>();
	}

	public HashSet<Exam> getExams() {
		return exams;
	}
	
	public void setExams(HashSet<Exam> exams) {
		assert !exams.isEmpty();
		Assert.notNull(exams);
		this.exams = exams;
	}

	@Min(1)
	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		Assert.notNull(number);
		this.number = number;
	}

	@NotBlank
	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		Assert.notNull(statement);
		this.statement = statement;
	}

	@Min(0)
	public Double getMaximunMark() {
		return maximunMark;
	}

	public void setMaximunMark(Double maximunMark) {
		Assert.notNull(maximunMark);
		this.maximunMark = maximunMark;
	}
	
	public void addExam(Exam exam)
	{
		Assert.notNull(exam);
		this.exams.add(exam);
		exam.addQuestion(this);
	}
	
	public void removeExam(Exam exam)
	{
		Assert.notNull(exam);
		this.exams.remove(exam);
		exam.removeQuestion(this);
	}

}
