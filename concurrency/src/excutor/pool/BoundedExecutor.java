package excutor.pool;

import java.util.concurrent.*;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class BoundedExecutor {
	private final Executor exec;
	private final Semaphore semaphore;
	
	public BoundedExecutor(Executor exec, int bound) {
		this.exec = exec;
		this.semaphore = new Semaphore(bound);
	}
	
	public void sumitTask(final Runnable command)
			throws InterruptedException {
		semaphore.acquire();
		try {
			exec.execute(new Runnable() {
				public void run() {
					try {
						command.run();
					} finally {
						semaphore.release();
					}
				}
			});
		} catch (RejectedExecutionException e) {
			semaphore.release();
		}
	}
}
