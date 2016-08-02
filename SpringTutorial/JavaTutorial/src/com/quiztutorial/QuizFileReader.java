package com.quiztutorial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class QuizFileReader {
	
	public static void main(String[] args)
	{
		QuizFileReader qReader = new QuizFileReader();
		qReader.readFile();
		
	}
	
	public void readFile()
	{
		BufferedReader inputStream = null;
		try
		{
			inputStream = new BufferedReader(new FileReader("src/com/quiztutorial/test.txt"));
			String line;
			Question qQuestion = new Question();
			List<Question> lQuestions = new ArrayList<Question>();
			StringBuffer sQuestion = new StringBuffer();
			String[] options = new String[6];
			while((line = inputStream.readLine()) != null){
				if(line.contains("Question")){
					qQuestion = new Question();
				}
				else if(line.contains("Ans")){
					line = line.replaceAll("Answer: ", "");
					qQuestion.setQuestion(sQuestion.toString());
					qQuestion.setOptions(options);
					qQuestion.setAnswer(line.split("&"));
					lQuestions.add(qQuestion);
					sQuestion = new StringBuffer();
					options = new String[6];
				}
				else if(line.startsWith("A. "))
				{
					options[0] = line;
					qQuestion.setOptions(options);
				}else if(line.startsWith("B. "))
				{
					options[1] = line;
					qQuestion.setOptions(options);
				}else if(line.startsWith("C. "))
				{
					options[2] = line;
					qQuestion.setOptions(options);
				}else if(line.startsWith("D. "))
				{
					options[3] = line;
					qQuestion.setOptions(options);
				}else if(line.startsWith("E. "))
				{
					options[4] = line;
					qQuestion.setOptions(options);
				}else if(line.startsWith("F. "))
				{
					options[5] = line;
					qQuestion.setOptions(options);
				} else {
					sQuestion.append(line+System.lineSeparator());
				}
			}
			int i =0;
			for(Question q : lQuestions)
			{
				System.out.println("  Question Number"+ i+++"  Options length  "+ q.getOptions().length+"  Answers length   "+ q.getAnswer().length);
				System.out.println(q);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
