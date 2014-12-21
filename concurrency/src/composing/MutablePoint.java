package composing;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class MutablePoint {
	public int x, y;
	
	public MutablePoint() { x = 0; y = 0; }
	public MutablePoint(MutablePoint p)  {
		this.x = p.x;
		this.y = p.y;
	}
}
