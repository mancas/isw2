package domain;

import java.util.Calendar;
import java.util.Date;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;


public class Registration extends DomainEntity{
	
	private Date moment;
	
	private ExamPaper exam_paper;
	private Payment payment;
	private Announcement announcement;
	
	public Registration()
	{
		super();
		this.moment = Calendar.getInstance().getTime();
		this.exam_paper = new ExamPaper();
		this.payment = new Payment();
		this.announcement = new Announcement();
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
		this.moment = moment;
	}
	
	public void setExamPaper(ExamPaper exam_paper)
	{
		this.exam_paper = exam_paper;
	}
	
	public void setPayment(Payment payment)
	{
		this.payment = payment;
	}
	
	@NotNull
	@Valid
	public Announcement getAnnouncement()
	{
		return this.announcement;
	}
	
	public void addAnnouncement(Announcement ann)
	{
		this.announcement = ann;
		ann.addRegistration(this);
	
	}
	
	public void removeAnnouncement(Announcement ann)
	{
		ann.removeRegistration(this);
	}
	
}
