package domain;

import java.util.ArrayList;
import java.util.Collection;

public class TestAnswer extends Answer{
	
	private Collection<Integer> selected;
	
	public TestAnswer()
	{
		super();
		this.selected = new ArrayList<Integer>();
	}
	
	// getters
	
	public Collection<Integer> getSelected()
	{
		return this.selected;
	}
	
	// setters
	
	// TODO: implement restriction TestAnswer-TestQuestion
	public void setSelected(Collection<Integer> selected)
	{
		this.selected = selected;
	}

}
