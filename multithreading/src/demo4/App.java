package demo4;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Enter a return key");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		proc1.shutdown();
	}
	
}

