package safety;

import java.math.BigInteger;

import javax.servlet.*;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet {
	private long count = 0;
	
	public long getCount() { return count; }
	
	public void service(ServletRequest req, ServletResponse resp) {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		++count;
		encodeIntoResponse(resp, factors);
	}
	
	private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
	}

	private BigInteger[] factor(BigInteger i) {
		return null;
	}

	private BigInteger extractFromRequest(ServletRequest req) {
		return null;
	}

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}
}
