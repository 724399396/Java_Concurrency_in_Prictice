package excutor.pool;

import java.util.*;
import java.util.concurrent.*;

public abstract class TransformingSequential {
	
	void processSequentially(List<Element> elements) {
		for (Element e : elements)
			process(e);
	}
	
	 void processInParallel(Executor exec, List<Element> elements) {
		 for (final Element e : elements) 
			 exec.execute(new Runnable() {
				 public void run() {
					 process(e);
				 }
			 });
	 }
	
	 public abstract void process(Element e);
	 
	 public <T> void sequentialRecursive(List<Node<T>> nodes,
			 					Collection<T> results) {
		 for (Node<T> n : nodes) {
			 results.add(n.compute());
			 sequentialRecursive(n.getChildern(), results);
		 }
	 }
	 
	 public <T> void parallelRecuresive(final Executor exec,
			 																List<Node<T>> nodes,
			 																final Collection<T> results) {
		 for(final Node<T> n : nodes) {
			 exec.execute(new Runnable() {
				 public void run() {
					 results.add(n.compute());
				 }
			 });
			 parallelRecuresive(exec, n.getChildern(), results);
		 }
	 }
	
	 public <T> Collection<T> getParalleResults(List<Node<T>> nodes)
	 		throws InterruptedException {
		 ExecutorService exec = Executors.newCachedThreadPool();
		 Queue<T> resultQueue = new ConcurrentLinkedQueue<T>();
		 parallelRecuresive(exec, nodes, resultQueue);
		 exec.shutdown();
		 exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		 return resultQueue;
	 }
	 
	interface Element {
	}
	
	interface Node <T> {
		T compute();
		
		List<Node<T>> getChildern();
	}
}
