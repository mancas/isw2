package domain;

import java.util.ArrayList;
import java.util.List;

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
		this.selected = selected;
	}

}
