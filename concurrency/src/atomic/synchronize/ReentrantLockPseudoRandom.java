package atomic.synchronize;

import java.util.concurrent.locks.*;

import net.jcip.annotations.*;

@ThreadSafe
public class ReentrantLockPseudoRandom extends PseudoRandom {
	private final Lock lock = new ReentrantLock(false);
	private int seed;
	
	ReentrantLockPseudoRandom(int seed) {
		this.seed = seed;
	}
	
	public int nextInt(int n) {
		lock.lock();
		try {
			int s = seed;
			seed = calculateNext(s);
			int remainder = s % n;
			return remainder >  0 ? remainder : remainder + n;
		} finally {
			lock.unlock();
		}
	}
}
