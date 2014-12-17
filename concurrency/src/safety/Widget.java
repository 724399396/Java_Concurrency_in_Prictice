package safety;

// 如果锁不可重入，这段代码将会产生死锁
public class Widget {
	public synchronized void doSomething() {}
}

class LoggingWidget extends Widget {
	public synchronized void soSomething() {
		System.out.println(toString() + ": calling doSomething");
		super.doSomething();
	}
}
