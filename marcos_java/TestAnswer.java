package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

import org.springframework.util.Assert;


@Entity
@Access(AccessType.PROPERTY)
public class TestAnswer extends Answer{
	
	private List<Integer> selected;
	
	public TestAnswer()
	{
		super();
		this.selected = new ArrayList<Integer>();
	}
	
	// getters
	
	public List<Integer> getSelected()
	{
		return this.selected;
	}
	
	// setters
	
	// TODO: implement restriction TestAnswer-TestQuestion
	public void setSelected(List<Integer> selected)
	{
		Assert.notNull(selected);
		this.selected = selected;
	}

}
