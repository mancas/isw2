package domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.util.Assert;


@Entity
@Access(AccessType.PROPERTY)
public class Registration extends DomainEntity{
	
	private Date moment;
	
	private ExamPaper exam_paper;
	private Payment payment;
	
	public Registration()
	{
		super();
		this.moment = Calendar.getInstance().getTime();
		this.exam_paper = new ExamPaper();
		this.payment = new Payment();
	}
	
	// getters
	
	@NotNull
	@Past
	public Date getMoment()
	{
		return this.moment;
	}
	
	@Valid
	public ExamPaper getExamPaper(){
		return this.exam_paper;
	}
	
	@Valid
	public Payment getPayment()
	{
		return this.payment;
	}
	
	// setters
	
	public void setMoment(Date moment)
	{
		Assert.notNull(moment);
		this.moment = moment;
	}
	
	public void setExamPaper(ExamPaper exam_paper)
	{
		Assert.notNull(exam_paper);
		this.exam_paper = exam_paper;
	}
	
	public void setPayment(Payment payment)
	{
		Assert.notNull(payment);
		this.payment = payment;
	}
}
