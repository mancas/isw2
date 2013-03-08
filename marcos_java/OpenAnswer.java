package domain;




public class OpenAnswer extends Answer{

	private String answer;
	
	public OpenAnswer()
	{
		super();
		this.answer = "answer";
	}
	
	public String getOpenAnswer()
	{
		return this.answer;
	}
	
	public void setOpenAnswer(String answer)
	{
		this.answer = answer;
	}
	
}
