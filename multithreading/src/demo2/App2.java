package demo2;


public class App2 {
	public static void main(String[] args) {

		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		t1.start();
		t2.start();
	}

}
