package domain;

import java.util.Date;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;


public class Registration extends DomainEntity{
	
	private Date moment;
	
	private ExamPaper exam_paper;
	private Payment payment;
	private Announcement announcement;
	private Customer customer;
	
	public Registration()
	{
		super();
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
	
	@Valid
	public Customer getCustomer()
	{
		return this.customer;
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
		if (payment.getRegister() != this || payment.getRegister() == null) {
			payment.setRegister(this);
		}
	}
	
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
		if (customer.getRegisters().contains(this)) {
			customer.addRegister(this);
		}
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
		if (!ann.getRegistrations().contains(this)) {
			ann.addRegistration(this);
		}
	
	}
	
	public void removeAnnouncement(Announcement ann)
	{
		ann.removeRegistration(this);
	}
	
}
