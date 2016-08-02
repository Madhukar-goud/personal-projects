package demo4;

public class Processor extends Thread {
	
	private volatile boolean shutdown = true;  

	@Override
	public void run() {
		
		while (shutdown) {
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		shutdown = false;
	}

}
