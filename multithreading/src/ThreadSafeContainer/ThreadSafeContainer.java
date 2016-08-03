package ThreadSafeContainer;

import java.util.LinkedList;
import java.util.List;

public class ThreadSafeContainer {

	private static ThreadSafeContainer instance = new ThreadSafeContainer();
	private List<Integer> queue;
	private int capacity = 10;
	
	private ThreadSafeContainer() {
		this.queue = new LinkedList<Integer>();
	}
	
	private ThreadSafeContainer(Integer size) {
		this.queue = new LinkedList<Integer>();
		this.capacity = size;
	}
	
	public static ThreadSafeContainer getInstance() {
		return instance;
	}
	
	public static ThreadSafeContainer getInstance(Integer size) {
		instance = new ThreadSafeContainer(size);
		return instance;
	}
	
	public void add(Integer i) throws InterruptedException {
		synchronized (this.queue) {
			System.out.println("In Add Method, queue size is ==> " + this.queue.size());
			while (this.queue.size() >= capacity) {
				this.queue.wait();
			}
			this.queue.add(i);
			this.queue.notify();
		}
	}
	
	public void remove() throws InterruptedException {
		synchronized (queue) {
			System.out.println("In Remove Method, queue size is ==> " + queue.size());
			while(queue.isEmpty()) {
				queue.wait();
			}
			queue.remove(0);
			queue.notify();
		}
	}
	
	public void clear() {
		queue.clear();
	}
}

