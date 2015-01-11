package memory.mode;

import net.jcip.annotations.*;

@ThreadSafe
public class SafeLazyInitialization {
	private static Resource resource;
	
	public synchronized static Resource getInstance() {
		if (resource == null)bh
			resource = new Resource();
		return resource;
	}
	
	static class Resource {
	}
}
