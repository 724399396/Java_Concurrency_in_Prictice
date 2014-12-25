package task.execute;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LifecycleWebServer {
	private final ExecutorService exec = Executors.newCachedThreadPool();
	
	public void start() throws IOException {
		@SuppressWarnings("resource")
		ServerSocket socket = new ServerSocket(80);
		while (!exec.isShutdown()) {
			try {
				final Socket conn = socket.accept();
				exec.execute(new Runnable () {
					public void run() {
						handleRequest(conn);
					}
				});
			} catch (RejectedExecutionException e) {
				if (!exec.isShutdown())
					log("task submission rejected", e);
			}
		}
	}
	
	public void stop() {
		exec.shutdown();
	}
	
	private void log(String msg, Exception e) {
		Logger.getAnonymousLogger().log(Level.WARNING, msg, e);
	}
	
	 void handleRequest(Socket connection) {
		 Request req = readRequest(connection);
		 if (isShutdownRequest(req))
			 stop();
		 else
			 dispatchRequest(req);
	 }
	 
	 interface Request {}
	 
	 private Request readRequest(Socket s) {
		 return null;
	 }
	 
	 private void dispatchRequest(Request r) {}
	 
	 private boolean isShutdownRequest(Request r) {
		 return false;
	 }
}
