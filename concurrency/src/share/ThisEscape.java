package share;

// 隐式地使this引用逸出（不要这么做）
public class ThisEscape {
	public ThisEscape(EventSource source) {
		source.registerListener(
				new EventListener() {
					@Override
					public void onEvent(Event e) {
						doSomething(e);
					}
				});
	}
	void doSomething(Event e) {}
}

class EventSource{
	void registerListener(EventListener el){}
}

class Event{}

interface EventListener {
	public void onEvent(Event e);
}
