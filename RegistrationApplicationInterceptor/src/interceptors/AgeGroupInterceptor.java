package interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class AgeGroupInterceptor implements Interceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		System.out.println("AgeGroupInterceptor - destroy() called");
	}

	@Override
	public void init() {
		System.out.println("AgeGroupInterceptor - init() called");
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println("AgeGroupInterceptor - Pre-processing");
		//avoir la stack
		ValueStack stack=ai.getStack();
		//recuperer l'âge
		Integer age = (Integer)stack.findValue("age");
		//String age = stack.findString("age");
		String ageGroup = "";
		if (age <= 18) {
			ageGroup = "Children";
		} else if (age > 18 && age <= 50) {
			ageGroup = "Adult";
		} else {
			ageGroup = "Senior";
		}
		//modifier l'âge
		stack.set("age", age + " ("+ageGroup+")");  
		String result = ai.invoke();
		System.out.println("AgeGroupInterceptor - Post-processing");
		return result;
	}

}
