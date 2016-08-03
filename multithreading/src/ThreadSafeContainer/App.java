package ThreadSafeContainer;

import java.util.Random;

public class App {

	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Random random = new Random();
				while(true) {
					try {
						ThreadSafeContainer.getInstance().add(random.nextInt(100));
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t2 =  new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						ThreadSafeContainer.getInstance().remove();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
