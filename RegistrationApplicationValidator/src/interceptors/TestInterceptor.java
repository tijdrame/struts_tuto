package interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class TestInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("TestInterceptor - destroy() called");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("TestInterceptor - init() called");
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestInterceptor - Pre-processing");
		String result = ai.invoke();
		System.out.println("TestInterceptor - Post-processing");
		return result;
	}

}
