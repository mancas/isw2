package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@Access(AccessType.PROPERTY)
public class Reviewer extends Actor {
	
	public Reviewer()
	{
		super();
	}

}
