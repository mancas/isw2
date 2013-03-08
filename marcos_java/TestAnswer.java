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
	
	private ArrayList<Integer> selected;
	
	public TestAnswer()
	{
		super();
		this.selected = new ArrayList<Integer>();
	}
	
	// getters
	
	public ArrayList<Integer> getSelected()
	{
		return this.selected;
	}
	
	// setters
	
	// TODO: implement restriction TestAnswer-TestQuestion
	public void setSelected(ArrayList<Integer> selected)
	{
		Assert.notNull(selected);
		this.selected = selected;
	}

}
