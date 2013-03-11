package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.Assert;


public class Company extends DomainEntity {

	private String name;
	private Collection<Certification> certifications;
	
	public Company()
	{
		super();
		
		this.certifications = new HashSet<Certification>();
	}

	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		//Assert.notNull(name);
		assert !name.isEmpty();
		this.name = name;
	}

	@Min(1)
	public Collection<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(Collection<Certification> certifications) {
		//Assert.notEmpty(certifications);

		this.certifications = certifications;
	}

	public void addCertification(Certification certification)
	{
		//Assert.notNull(certification);
		this.certifications.add(certification);
		certification.addCompany(this);
	}
	
	public void removeCertification(Certification certification)
	{
		//Assert.notNull(certification);
		this.certifications.remove(certification);
		certification.removeCompany(this);
	}
}
