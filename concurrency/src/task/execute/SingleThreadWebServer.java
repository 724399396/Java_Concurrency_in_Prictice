package task.execute;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class SingleThreadWebServer {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ServerSocket socket = new ServerSocket(80);
		while (true) {
			Socket connection = socket.accept();
			handleRequest(connection);
		}
	}
	private static void handleRequest(Socket connection) {
	        // request-handling logic here
	 }
}
