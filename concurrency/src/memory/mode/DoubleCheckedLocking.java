package memory.mode;

import net.jcip.annotations.*;

@NotThreadSafe
public class DoubleCheckedLocking {
	private static Resource resource;

	public static Resource getInsance() {
		if (resource == null) {
			synchronized (DoubleCheckedLocking.class) {
				if (resource == null)
					resource = new Resource();
			}
		}
		return resource;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	}
	
	static class Resource {
	}
}
