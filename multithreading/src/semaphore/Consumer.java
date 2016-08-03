package semaphore;

import ThreadSafeContainer.ThreadSafeContainer;

public class Consumer extends Thread {

	private int m;
	
	public Consumer(int m) {
		this.m = m;
	}
	public void run() {
		for (int i=0; i< m; i++) {
			try {
				ThreadSafeContainer.getInstance().remove();
				//Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
