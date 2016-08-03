package semaphore;

public class AppProdCons {

	public static void main(String[] args) {

		Thread t1 = new Producer(10);
		Thread t2 = new Consumer(10);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
