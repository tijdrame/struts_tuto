package action.user;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

@Namespace("/user")
@Action("/getDetails")
@ResultPath("/view/user")
@Result(name = "success", location = "user.jsp")
//@Result(name = "success", location = "/view/user/user.jsp")
public class UserDetailAction {
	public String execute() {
		System.out.println("execute() method of UserDetailAction called");
		return "success"; 
	}
}
