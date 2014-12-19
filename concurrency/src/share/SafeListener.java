package share;

public class SafeListener {
	private final EventListener listener;
	
	private SafeListener() {
		listener = new EventListener() {
			@Override
			public void onEvent(Event e) {
				doSomething(e);
			}
		};
	}
	private void doSomething(Event e){}
	
	public static SafeListener newInstance(EventSource source) {
		SafeListener safe = new SafeListener();
		source.registerListener(safe.listener);
		return safe;
	}
}
