package performance.scalable;

import java.util.*;
import java.util.regex.Pattern;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class AttributeStore {
	@GuardedBy("this") private final Map<String, String> attributes =
			new HashMap<String, String>();
	
	public synchronized boolean userLocationMatches(String name, String regexp) {
		String key = "users." + name + ".location";
		String location = attributes.get(key);
		if (location == null)
			return false;
		else
			return Pattern.matches(regexp, location);
	}
}
