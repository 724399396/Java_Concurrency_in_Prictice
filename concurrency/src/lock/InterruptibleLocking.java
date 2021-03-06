package lock;

import java.util.concurrent.locks.*;

public class InterruptibleLocking {
	private Lock lock = new ReentrantLock();
	
	public boolean sendOnSharedLine(String message)
			throws InterruptedException {
		lock.lockInterruptibly();
		try {
			return cancellableSendOnSharedLine(message);
		} finally {
			lock.unlock();
		}
	}
	
	private boolean cancellableSendOnSharedLine(String mesaage) {
		/* send something */
		return true;
	}
}
