package composing;

import net.jcip.annotations.GuardedBy;

public class PrivateLock {
	private final Object myLock = new Object();
	@GuardedBy("myLock") Widget widget;
	
	void someMethod() {
		synchronized(myLock) {
			// 访问或者修改Widget的状态
		}
	}
}

class Widget {}
