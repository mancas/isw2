package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.Assert;

import security.UserAccount;

@SuppressWarnings("serial")
@Entity
@Access(AccessType.PROPERTY)
public abstract class Actor extends UserAccount {
	
	private String name;
	private Integer phone;
	private String email;
	private String address;

	public Actor()
	{
		super();
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		Assert.notNull(name);
		this.name = name;
	}

	@Pattern(regexp="[0..9]{9]}")
	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		Assert.notNull(phone);
		this.phone = phone;
	}

	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		Assert.notNull(email);
		this.email = email;
	}

	@NotBlank
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		Assert.notNull(address);
		this.address = address;
	}
	
	
}
