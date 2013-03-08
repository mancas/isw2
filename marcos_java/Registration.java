package domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.util.Assert;



@Access(AccessType.PROPERTY)
public class Registration extends DomainEntity{
	
	private Date moment;
	private ExamPaper examPaper;
	private Payment payment;
	
	public Registration()
	{
		super();
		this.moment = Calendar.getInstance().getTime();
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
		return this.examPaper;
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
	
	public void setExamPaper(ExamPaper examPaper)
	{
		Assert.notNull(examPaper);
		this.examPaper = examPaper;
	}
	
	public void setPayment(Payment payment)
	{
		Assert.notNull(payment);
		this.payment = payment;
	}
}
