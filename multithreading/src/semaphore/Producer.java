package semaphore;

import java.util.Random;

import ThreadSafeContainer.ThreadSafeContainer;

public class Producer extends Thread {
	private int n;
	public Producer(int n) {
		this.n = n;
	}

	public void run() {
		Random random = new Random();
		for (int i = 0; i< n;i++) {
			try {
				ThreadSafeContainer.getInstance().add(random.nextInt(100));
				//Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
