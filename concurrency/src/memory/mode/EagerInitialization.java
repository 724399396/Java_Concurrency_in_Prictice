package memory.mode;

import net.jcip.annotations.*;

@ThreadSafe
public class EagerInitialization {
	private static Resource resource = new Resource();
	
	public static Resource getResource() {
		return resource;
	}
	
	static class Resource {
	}
}
