package building.blocks;

public class LaunderThrowable {
	
	/** 如果Throwable 是 Error, 那么抛出他；如果是RuntimeException, 那么返回他，
	 * 否则跑出 IllegalStateException。
	 */
	public static RuntimeException launderThrowable(Throwable t) {
		if (t instanceof RuntimeException)
			return (RuntimeException)t;
		else if (t instanceof Error)
			throw (Error) t;
		else
			throw new IllegalStateException("Not unchecked", t);
	}
}
