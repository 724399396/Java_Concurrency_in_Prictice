package task.execute;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadPerTaskWebServer {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket socket = new ServerSocket(80);
		while (true) {
			final Socket connection = socket.accept();
			Runnable task = new Runnable() {
				@Override
				public void run() {
					handleRequest(connection);
				}
			};
			new Thread(task).start();
		}
	}
	   private static void handleRequest(Socket connection) {
	        // request-handling logic here
	    }
}
