package domain;

import java.util.ArrayList;
import org.hibernate.validator.constraints.NotEmpty;

public class TestQuestion extends Question {

	private ArrayList<String> answers;
	private ArrayList<Integer> corrects;
	
	public TestQuestion()
	{
		super();

		this.answers = new ArrayList<String>();
		this.corrects = new ArrayList<Integer>();
	}

	@NotEmpty
	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	@NotEmpty
	public ArrayList<Integer> getCorrects() {
		return corrects;
	}

	public void setCorrects(ArrayList<Integer> corrects) {

		Integer maxIndex = this.answers.size() - 1;

		for (int i = 0; i < corrects.size(); i++) {
			if (corrects.get(i) > maxIndex) {
				throw new IllegalArgumentException("Corrects must have a value in range 1.." + maxIndex);
			} else {
				this.corrects.add(corrects.get(i));
			}
		}
	}
	
}
