package composing;

import java.util.Vector;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class BetterVector<E> extends Vector<E> {
	private static final long serialVersionUID = -507383330074724590L;

	public synchronized boolean putIfAbsent(E x) {
		boolean absent = !contains(x);
		if (absent)
			add(x);
		return absent;
	}
}
