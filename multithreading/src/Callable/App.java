package Callable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[]  args){
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<Integer> future = executorService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Random random = new Random();
				Integer duration = random.nextInt(4000);
				if (duration > 2000) {
					throw new Exception("Duration greater than 2k");
				}
				Thread.sleep(duration);
				System.out.println("Finished ==> " + duration);
				return duration;
			}
		});
		
		executorService.shutdown();
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			System.out.println("Duration is ==> " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("Exception ==> " + e);
		}
	}
}
