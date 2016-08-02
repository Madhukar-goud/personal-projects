package com.quiztutorial;

import java.util.Arrays;

public class Question {
	private String question;
	private String[] options;
	private String[] answer;
	
	public String getQuestion() {
		return question;
	}
	@Override
	public String toString() {
		return "Question [question=" + question + ", options="
				+ Arrays.toString(options) +System.lineSeparator()+ ", answer="
				+ Arrays.toString(answer) + "]";
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public String[] getAnswer() {
		return answer;
	}
	public void setAnswer(String[] answer) {
		this.answer = answer;
	}
	
}
