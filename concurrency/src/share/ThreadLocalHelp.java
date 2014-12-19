package share;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadLocalHelp {
	private static final String DB_URL = "";
	
	private static ThreadLocal<Connection> connectionHolder
		= new ThreadLocal<Connection>() {
				public Connection initialValue() {
					Connection connection = null;
					try {
						connection =DriverManager.getConnection(DB_URL);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return connection;
				}
	};
	
	public static Connection getConnection() {
		return connectionHolder.get();
	}
}
