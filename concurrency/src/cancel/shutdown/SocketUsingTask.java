package cancel.shutdown;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import net.jcip.annotations.ThreadSafe;

public abstract class SocketUsingTask {

}

interface CancellableTask<T> extends Callable<T> {
	void cancel();
	
	RunnableFuture<T> newTask();
}

@ThreadSafe
class CancellingExecutor extends ThreadPoolExecutor {
	public CancellingExecutor(int corePoolSize, int maximumPollSize, long keepAliveTime,
						TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPollSize, keepAliveTime, unit, workQueue);
	}
	
	public CancellingExecutor(int corePoolSize, int maximumPollSize, long keepAliveTime,
			TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
		super(corePoolSize, maximumPollSize, keepAliveTime, unit, workQueue, threadFactory);
	}
	
    public CancellingExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, 
    		TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }
    
    protected<T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
    	if (callable instanceof CancellableTask)
    		return ((CancellableTask<T>) callable).newTask();
    	else
    		return super.newTaskFor(callable);
    }
}
