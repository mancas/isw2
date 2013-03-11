package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;


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
		assert !name.isEmpty();
		this.name = name;
	}

	@Min(1)
	public Collection<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(Collection<Certification> certifications) {
		this.certifications = certifications;
	}

	public void addCertification(Certification certification)
	{
		this.certifications.add(certification);
		if (!certification.getCompanies().contains(this)) {
			certification.addCompany(this);
		}
	}
	
	public void removeCertification(Certification certification)
	{
		this.certifications.remove(certification);
		if (certification.getCompanies().contains(this)) {
			certification.removeCompany(this);
		}
	}
}
