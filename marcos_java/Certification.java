package domain;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;


public class Certification extends DomainEntity {

	private String title;
	private String description;
	private Date extinctionDate;
	private Collection<Company> companies;
	private Collection<Exam> exams;
	
	public Certification()
	{
		super();
		this.companies = new HashSet<Company>();
		this.exams = new HashSet<Exam>();
	}

	@NotBlank
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		//Assert.notNull(title);
		assert !title.isEmpty();
		this.title = title;
	}

	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		//Assert.notNull(description);
		assert !description.isEmpty();
		this.description = description;
	}

	public Date getExtinctionDate() {
		return extinctionDate;
	}

	public void setExtinctionDate(Date extinctionDate) {
		Date now = Calendar.getInstance().getTime();
		if (now.compareTo(extinctionDate) > 0) {
			throw new IllegalArgumentException("Certification Extinction Date must be an instance of future");
		}
		this.extinctionDate = extinctionDate;
	}

	@Min(1)
	public Collection<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(HashSet<Company> companies) {
		//Assert.notNull(companies);
		assert !companies.isEmpty();
		this.companies = companies;
	}
	
	public void addCompany(Company company)
	{
		//Assert.notNull(company);
		this.companies.add(company);
		company.addCertification(this);
	}
	
	public void removeCompany(Company company)
	{
		//Assert.notNull(company);
		this.companies.remove(company);
		company.removeCertification(this);
	}
	
	public Collection<Exam> getExams() {
		return exams;
	}

	public void setExams(Collection<Exam> exams) {
		//Assert.notNull(exams);
		assert !exams.isEmpty();
		this.exams = exams;
	}
	
	public void addExam(Exam exam)
	{
		//Assert.notNull(exam);
		this.exams.add(exam);
		exam.setCertifications(this);
	}
	
	public void removeExam(Exam exam)
	{
		//Assert.notNull(exam);
		this.exams.remove(exam);
		exam.setCertifications(null);
	}
}
