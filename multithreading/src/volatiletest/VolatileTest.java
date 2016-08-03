package volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

	private volatile AtomicInteger value;

	public void increment() {
		value.incrementAndGet();
	}
	
	public int square() {
		return value.get()*value.get();
	}

}
