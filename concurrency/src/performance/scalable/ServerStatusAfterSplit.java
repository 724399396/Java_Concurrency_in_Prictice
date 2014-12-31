package performance.scalable;

import net.jcip.annotations.*;

import java.util.*;

@ThreadSafe
public class ServerStatusAfterSplit {
	@GuardedBy("this") public final Set<String> users;
	@GuardedBy("queries") public final Set<String> queries;
	
	public ServerStatusAfterSplit() {
		users = new HashSet<String>();
		queries = new HashSet<String>();
	}
	
	public void addUser(String u) {
		synchronized (users) {
			users.add(u);
		}
	}
	
	public void addQuery(String q) {
		synchronized (queries) {
			queries.add(q);
		}
	}
	
	public void removeUser(String u) {
		synchronized (users) {
			users.remove(u);
		}
	}
	
	public void removeQuery(String q) {
		synchronized (queries) {
			queries.remove(q);
		}
	}
}
