package com.madhukar.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/com/madhukar/tutorial/student.xml");

      System.out.println(System.getProperty("java.version"));
      Student student = (Student) context.getBean("student");
      System.out.println("Name : " + student.getName());
      System.out.println("Age : " + student.getAge());
   }
}
