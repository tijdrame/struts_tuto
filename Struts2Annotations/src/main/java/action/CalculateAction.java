package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

//1 seul result 
@Result(name = "success", location = "/success.jsp")
public class CalculateAction {
	@Action("/calculateEMI")
	public String calculateEMI() {
		System.out.println("calculateEMI() called");
		return "success";
	}
	@Action("/calculateInterestRate")
	public String calculateInterestRate() {
		System.out.println("calculateInterestRate() called");
		return "success";
	}
	@Action("/calculateIncomeTax")
	public String calculateIncomeTax() {
		System.out.println("calculateIncomeTax() called");
		return "success";
	}
}
