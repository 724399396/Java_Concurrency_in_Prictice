package cancel.shutdown;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimedRun1 {
	private static final ScheduledExecutorService cancelExec = 
			Executors.newScheduledThreadPool(1);
	
	public static void timeRun(Runnable r,
										long timeout, TimeUnit unit) {
		final Thread taskThread = Thread.currentThread();
		cancelExec.schedule(new Runnable() {
			public void run() {
				taskThread.interrupt();
			}
		}, timeout, unit);
		r.run();
	}
}
